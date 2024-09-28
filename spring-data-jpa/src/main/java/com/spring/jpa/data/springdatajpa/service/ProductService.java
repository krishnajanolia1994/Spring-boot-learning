package com.spring.jpa.data.springdatajpa.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.jpa.data.springdatajpa.entity.Product;

public interface ProductService {
	
	public Product save(Product product);

	public List<Product> saveAll(List<Product> product);

	public List<Product> getAll();

	public Product findById(Long id);

	public void deleteById(Long id);

	public void deleteAll();

	public void deleteByIds(List<Long> ids);

	public void deleteByProducts(List<Product> products);

	public boolean isProductExist(Long id);

	public List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2);

	public List<Product> getAll(String price, String name,String dir);

	public Page<Product> getAll(boolean advanceSearch, List<String> facilityId, String search, Map<String, Object> context,
			Pageable pageable);


}
