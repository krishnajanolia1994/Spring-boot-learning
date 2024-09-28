package com.spring.jpa.data.springdatajpa.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.PageImpl;
import com.spring.jpa.data.springdatajpa.constants.Constants;
import com.spring.jpa.data.springdatajpa.entity.Product;
import com.spring.jpa.data.springdatajpa.repository.ProductRepository;
import com.spring.jpa.data.springdatajpa.service.ProductService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
@Scope(	)
public class ProductServiceImp implements ProductService{
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> saveAll(List<Product> products) {
		return productRepository.saveAll(products);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		Product product = new Product();
		if(productRepository.getById(id)!=null)
			product=productRepository.getById(id);
		return product;
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
		
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		productRepository.deleteAllById(ids);
	}

	@Override
	public void deleteByProducts(List<Product> products) {
		productRepository.deleteAll(products);
	}

	@Override
	public boolean isProductExist(Long id) {
		return productRepository.existsById(id);
	}

	@Override
	public List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(price1, price2);
	}

	@Override
	public List<Product> getAll(String price, String name,String dir) {
		
		Sort sortPrice = dir.equals("asc")? Sort.by(price).ascending():Sort.by(price).descending();
		
		Sort sortName = dir.equals("asc")? Sort.by(name).ascending():Sort.by(name).descending();
		
		Sort sortByPriceAndName = sortPrice.and(sortName);

		return productRepository.findAll(sortByPriceAndName);
	}

	@Override
	public Page<Product> getAll(boolean advanceSearch, List<String> facilityId, String search, Map<String, Object> context,
			Pageable pageable) {
		Constants constants;
		
		String name = (String) context.get(Constants.NAME);
		String imageUrl = (String) context.get(Constants.IAMGE_URL);
		
		String description = (String) context.get(Constants.DESCRIPTION);

		BigDecimal p1 = (BigDecimal) context.get("p1");

		BigDecimal p2 = (BigDecimal) context.get("p2");

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		
		Root<Product> root = cq.from(Product.class);
		
		List<Predicate> prdicates = new ArrayList<Predicate>();
		
		if(search!=null && !search.equals("")) {
			
			prdicates.add(
					cb.or(cb.like(root.get(Constants.NAME), "%"+name+"%"),
							cb.like(root.get(Constants.IAMGE_URL), "%"+imageUrl+"%"),
							cb.like(root.get(Constants.DESCRIPTION), "%"+description+"%")
							)
					
					);
		}
		
		prdicates.add(cb.between(root.get(Constants.PRICE), p1, p2));
		
		long count = entityManager.createQuery(cq).getResultList().size();

        List<Product> products = entityManager.createQuery(cq)
				.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize())
				.getResultList();
		 
		return new PageImpl<>(products, pageable, count);
	}

	

}
