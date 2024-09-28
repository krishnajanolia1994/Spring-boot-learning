package com.spring.jpa.data.springdatajpa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.data.springdatajpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2);

}
