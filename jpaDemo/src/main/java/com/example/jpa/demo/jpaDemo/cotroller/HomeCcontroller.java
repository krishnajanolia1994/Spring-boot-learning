package com.example.jpa.demo.jpaDemo.cotroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.jpa.demo.jpaDemo.model.Person;
import com.example.jpa.demo.jpaDemo.model.exception.ProductNotFoundException;
import com.example.jpa.demo.jpaDemo.repo.PersonRepo;

@Controller
public class HomeCcontroller {
	
	// the below resttemplate has been creaated in main method
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	PersonRepo personRepo;
	
	@GetMapping("home")
	public String home() {
		return "home.jsp";
		
	}
	
	@PostMapping("addAlien")
	public String home(Person person) {
		if(person!=null && person.getId()!=0) 
			personRepo.save(person);
		return "home.jsp";
		
	}
	
	@PostMapping("productNotFound")
	public String productNotFound(Person person) throws ProductNotFoundException {
		if(person!=null && person.getId()!=0) 
			personRepo.save(person);
		else 
			throw new ProductNotFoundException("product not found");

		return "home.jsp";
		
	}
	
	@GetMapping("itrseptor")
	public String itrseptor() {
		
		System.out.println("inside comtroller");
		return "home.jsp";
		
	}
	
	/////////////////////////////////Rest template/////////////////////////////
	@GetMapping("restTamplate")
	public String restTamplate() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("name", "krishna");
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      Person person = new Person();
	      person.setId(123456);
	      person.setName("kdjskh");
	      
	      HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);
	      restTemplate.exchange("http://localhost:8080/addAlien", HttpMethod.POST, entity, String.class).getBody();
		return "home.jsp";
		
	}
	
	//////////////////////////////// file upload/////////////////////////////////////

}
