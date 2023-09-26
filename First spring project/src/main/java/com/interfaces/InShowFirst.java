package com.interfaces;

public interface InShowFirst {
	
	default void show() {
		  
		System.out.print("InShowFirst");
		
	}
	
	public void getName();
	
	public void getSurname();
	
	

}
