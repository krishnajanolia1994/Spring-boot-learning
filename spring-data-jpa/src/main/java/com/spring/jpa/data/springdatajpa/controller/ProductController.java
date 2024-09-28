package com.spring.jpa.data.springdatajpa.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
import org.springframework.data.domain.Page;


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
	
	@GetMapping(value = "/get/price/between")
	public List<Product> getByPriceBetween(@RequestParam("price1") BigDecimal price1,
			@RequestParam("price2") BigDecimal price2 ){
		
		return productService.findByPriceBetween(price1,price2);
		
	}
	
	@GetMapping(value = "/get/all/with/sort")
	public List<Product> getAllWithSort(@RequestParam("price") String price,
			@RequestParam("name") String name ,@RequestParam("dir") String dir){
		return productService.getAll(price,name,dir);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<Product>> getAllFacilityLocation(
			@RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "advanceSearch", required = false) boolean advanceSearch,
			@RequestParam(value = "search", required = false) String search, @RequestParam Map<String, Object> context,
			Pageable pageable) {
		return new ResponseEntity<>(productService.getAll(advanceSearch, ids, search, context, pageable),
				HttpStatus.OK);
	}
	
	
	
 
}
