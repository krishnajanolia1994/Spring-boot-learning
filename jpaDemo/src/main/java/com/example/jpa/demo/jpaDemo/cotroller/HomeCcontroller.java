package com.example.jpa.demo.jpaDemo.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jpa.demo.jpaDemo.model.Person;
import com.example.jpa.demo.jpaDemo.repo.PersonRepo;

@Controller
public class HomeCcontroller {
	
	@Autowired
	PersonRepo personRepo;
	
	@GetMapping("home")
	public String home() {
		return "home.jsp";
		
	}
	
	@GetMapping("addAlien")
	public String home(Person person) {
		if(person!=null && person.getId()!=0) 
			personRepo.save(person);
		return "home.jsp";
		
	}

}
