package com.example.config.seerver.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
	
	//  http://localhost:8080/actuator  use this url

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
