package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Bill;

@Repository
public interface BillDAO extends CrudRepository<Bill, Integer>{
	
	List<Bill> findAll();

	List<Bill> getByMonth(int month);
	

}