package com;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interfaces.InShowFirst;

@RestController
@SpringBootApplication
public class MyApplication {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MyApplication.class);


    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
    	
//    	List<Object> list1 = new ArrayList<Object>();
//    	
//    	Demo demo = new Demo();
//    	
//    	demo.setStr("kri");
//    	
//    	Demo2 demo2 = new Demo2();
//    	
//    	demo2.setStr("kri");
//    	
//    	list1.add(demo);
//    	
//    	
//    	ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
//    	
    	
    	
//    	for(int i=0;i<10;i++) {
//    		System.out.print(i+" ");
//    		if(i%2 == 0)
//    			continue;
//    		System.out.println();
//
//    	}
       
    	List<Integer> list = Arrays.asList(1,2,3,4,5,5,5,3,4,2,3,4,3,2,4,6,3,1,2);
    	
    	Collections.sort(list);
    	List list1 = new ArrayList();
//    	Collections.checkedCollection(list, Integer.class);
    	
    	
    	System.out.println(Collections.binarySearch(list, 1));
    	
    	list.add(1);
    	
//    	Set<Integer> set  = list.stream().filter(i-> i%2==0).map(i-> i*i).collect(Collectors.toSet());
//    	
//    	set.forEach(i-> System.out.print(i+" "));
//    	
//    	System.out.print(list.stream().anyMatch(i-> i==2));
//    	list.stream().anyMatch(i-> i==2);
    	
    	
    	
//    	List<Integer> li= Arrays.asList(1,3,4,45,45,45,54,22,4);
//    	
//    	li.stream().distinct().filter(i-> {
//    		boolean b = true;
////    		System.out.println(b);
//    		if(i%2==0)
//    			b=false;
//    		return b;
//    	}).forEachOrdered(i-> System.out.println(i));;
    	
//    	final int sum =1;
//    	li.forEach(i -> {
//    		sum+=i;
//    	});
    	
//    	InShowFirst ob1 = 
    	
//    	Runtime r = Runtime.getRuntime();
//        Process p = nul;
//        try {
//          p = r.exec("notepad");
//        } catch (Exception e) {
//          System.out.println("Error executing notepad.");
//}
//    	
//    	Demo demo = new Demo();
//    	
//    	SortedSet<Integer> set = new TreeSet<Integer>(); 
    	
    	
//    	int [] ar = new int[-10];
//    	
//    	logger.info("Hi this is my first log");
//    	
//    	Demo demo = new Demo();
//    	
//    	boolean t = true;
//        first: {
//          second: {
//            third: {
//              System.out.println("Before the break.");
//              if(t) break second; // break out of second block
//              System.out.println("This won't execute");
//    }
//            System.out.println("This won't execute");
//          }
//          System.out.println("This is after second block.");
//        }
//    	
    	
    	
//    	SpringApplication.run(MyApplication.class, args);
//    	pringApplication.set
    	
//    	SpringApplication application = new SpringApplication(MyApplication.class);
//        application.run(args);
    	
//    	char ch ='A';
//    	char sm = 'b';
//    	int j=sm;
//    	int i = ch;
//    	
//    	Demo2 demo2= new Demo2();
//    	
//    	
//    	
//    	demo2.setObj(5.5);
//    	demo2.getObj();
//    	System.out.println(demo2.getObj());
//    	System.out.println(i);
//    	
//    	String str ="Krishna";
//    	
//    	
//    	
//    	byte [] by = str.getBytes();
//    	for(i=0;i<by.length;i++) {
//    		System.out.println(by[i]);
//    	}
//    	
//    	for(char chi=65;chi<301;chi++) {
//    	
//		System.out.println(chi);
//    	}
		
		

    	
//    	Demo demo = new Demo();
//    	for(int i=0;i<10;i++) {
//    		System.out.println("inside main thread "+i);
//    		try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	}
    }

}

