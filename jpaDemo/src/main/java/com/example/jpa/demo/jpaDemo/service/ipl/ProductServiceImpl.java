package com.example.jpa.demo.jpaDemo.service.ipl;

import org.springframework.stereotype.Service;

import com.example.jpa.demo.jpaDemo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Override
	public void show() {
		System.out.println("hi");
	}

}
