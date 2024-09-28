package com.spring.jpa.data.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static java.lang.Math.sqrt;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		
		MyClass myClass = new MyClass();
		int x=0;
		
		Runnable put= ()->{
			for(int i=0;i<10;i++) {
				myClass.put(i);
			}
		};
		
		Runnable get=()->{
			for(int i=0;i<10;i++) {
				myClass.get();
			}
		};
		
		Thread p1=new Thread(put);
		Thread p2=new Thread(get);
		p1.start();
		p2.start();
		
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
