package com.spring.jpa.data.springdatajpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.jpa.data.springdatajpa.entity.Product;
import com.spring.jpa.data.springdatajpa.repository.ProductRepository;
import com.spring.jpa.data.springdatajpa.service.ProductService;

@Component
public class ProductServiceImp implements ProductService{
	
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

	

}
