package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Bill;


@Repository
public interface BillDAO extends CrudRepository<Bill, Integer>{
	
	@Query(value = "SELECT * FROM bills", nativeQuery = true)
	List<Bill> findAllBills();
	
	
//	@Query(value = "SELECT * FROM bills where consumer_id=?", nativeQuery = true)
//	List<Bill> findBillByConsumerId(int consumerId);
	
	
	@Query(value = "SELECT * FROM generated_bill where month=?", nativeQuery = true)
	List<Bill> findBillByMonth(Integer month);
	
	
}