package com.spring.jpa.data.springdatajpa.entity.inheritence;

import jakarta.persistence.Entity;



@Entity
public class Child extends ParentAbstract{
	
	
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	
	
	
}
