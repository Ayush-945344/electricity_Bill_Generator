package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.GenerateBillDTO;

@Repository
public interface GeneratedBillDAO extends CrudRepository<GenerateBillDTO, Integer> {

	@Query(value = "SELECT * FROM generated_bill", nativeQuery = true)
	List<GenerateBillDTO> findAllBills();
	
	@Query(value = "SELECT * FROM generated_bill where consumer_id=?", nativeQuery = true)
	List<GenerateBillDTO> findBillByConsumerId(Integer consumerId);
	
	
	@Query(value = "SELECT * FROM generated_bill where month=? and year=? ", nativeQuery = true)
	List<GenerateBillDTO> findByMonthAndYear(Integer month,Integer year);
	
	@Query(value = "SELECT * FROM generated_bill where month=?", nativeQuery = true)
	List<GenerateBillDTO> findByMonth(Integer month);
	
	@Query(value = "SELECT * FROM generated_bill where year=?", nativeQuery = true)
	List<GenerateBillDTO> findByYear(Integer year);

	@Query(value = "SELECT * FROM generated_bill where consumer_id=? and month=? and year=?", nativeQuery = true)
	GenerateBillDTO findByIdAndMonthAndYear(int consumerId, int month,int year);

	@Query(value = "SELECT * FROM generated_bill where consumer_id=? and year=?", nativeQuery = true)
	GenerateBillDTO findByIdAndYear(int consumerId, int year);

	@Query(value = "SELECT * FROM generated_bill where consumer_id=? and month=?", nativeQuery = true)
	GenerateBillDTO findByIdAndMonth(int consumerId, int month);

}
