package com.example.jpa.demo.jpaDemo.cotroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.jpa.demo.jpaDemo.model.Person;
import com.example.jpa.demo.jpaDemo.model.exception.ProductNotFoundException;
import com.example.jpa.demo.jpaDemo.repo.PersonRepo;
import com.example.jpa.demo.jpaDemo.service.ProductService;
import javax.persistence.criteria.Predicate;


@Controller
public class HomeCcontroller {
	
	// the below resttemplate has been creaated in main method
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductService productService;
	
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
	@RequestMapping(value = "/upload", method = RequestMethod.POST, 
		      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		
		File myFile = new File("/home/ubuntu/spring-boot-learning /files"+file.getName());
		myFile.createNewFile();	
		FileOutputStream out = new FileOutputStream(myFile);
		out.write(file.getBytes());
		out.close();
		return "file uploaded";
	}
	
	///////////////////////////////////////file Download ///////////////////////////////////////
	
	@RequestMapping(value = "/download", method = RequestMethod.GET) 
	public ResponseEntity<Object> downloadFile() throws IOException  {
	   String filename = "/var/tmp/mysql.png";
	   File file = new File(filename);
	   InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	   HttpHeaders headers = new HttpHeaders();
	      
	   headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	   headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	   headers.add("Pragma", "no-cache");
	   headers.add("Expires", "0");
	      
	   ResponseEntity<Object> 
	   responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
	      MediaType.parseMediaType("application/txt")).body(resource);
	      
	   return responseEntity;
	}
	
	/////////////////////////////////   use of @service/////////////////////////////////////////////////
	
	@GetMapping("service")
	@ResponseBody
	public String service() {
		productService.show();
		return "";
		
	}

}
