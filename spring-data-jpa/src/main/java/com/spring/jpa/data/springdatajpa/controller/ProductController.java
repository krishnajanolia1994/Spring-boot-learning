package com.spring.jpa.data.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.data.springdatajpa.entity.Product;
import com.spring.jpa.data.springdatajpa.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(value = "/save")
	public Product save(@RequestBody Product product) {
		
		return productService.save(product);
		
	}
	
	@PostMapping(value = "/save/all")
	public List<Product> saveAll(@RequestBody List<Product> product) {
		
		return productService.saveAll(product);
		
	}
	
	@GetMapping(value = "/get/all")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	@GetMapping(value = "/get/{id}")
	public Product getById(@PathVariable("id") Long id){
		Product product = null;
		
		if(productService.isProductExist(id)) {
			 product = productService.findById(id);
		}
		
		return product;
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}
	
	@DeleteMapping(value = "/delete/all")
	public void deleteAll() {
		productService.deleteAll();
	}
	
	
	@DeleteMapping(value = "/delete/all/by/ids")
	public void deleteById(@RequestParam("ids") List<Long> ids) {
		productService.deleteByIds(ids);
	}
	
	@DeleteMapping(value = "/delete/all/by/products")
	public void deleteBy(@RequestBody List<Product> products) {
		productService.deleteByProducts(products);
	}
	
	
	
 
}
