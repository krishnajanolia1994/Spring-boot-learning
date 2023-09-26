package com.spring.jpa.data.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.data.springdatajpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
