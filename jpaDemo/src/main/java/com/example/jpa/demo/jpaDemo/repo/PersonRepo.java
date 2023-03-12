package com.example.jpa.demo.jpaDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.demo.jpaDemo.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{

}
