package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Consumer;

@Repository
public interface ConsumerDAO extends CrudRepository<Consumer, Integer>{
	
	List<Consumer> findAll();
	
	

}
