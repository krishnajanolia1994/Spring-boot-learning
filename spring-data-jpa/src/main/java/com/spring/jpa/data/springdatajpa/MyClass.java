package com.spring.jpa.data.springdatajpa;
import java.util.function.Consumer;

import static com.spring.jpa.data.springdatajpa.StaticDemo.show;

public class MyClass {
	
	
	
	private int x;
	
	private boolean flag = false;

	
	
	public synchronized void put(int a) {
		Byte b=10;
		
		if(flag)
			try {
				wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.x=a;
		System.out.println("put "+a);
		flag=true;
		notify();
		
	}
	
	public synchronized void get() {
		
		if(!flag)
			try {
				wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("got "+x);
		flag=false;
		notify();
	}
	
	
	
	
	
	 

}
