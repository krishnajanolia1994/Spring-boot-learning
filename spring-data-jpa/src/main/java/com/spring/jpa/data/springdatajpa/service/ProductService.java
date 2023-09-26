package com.spring.jpa.data.springdatajpa.service;

import java.util.List;

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


}
