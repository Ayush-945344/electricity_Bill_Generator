package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.BillDAO;
import com.example.demo.Entity.Bill;

@Service
public class BillServices {
	
	@Autowired
	private BillDAO billDAO;
	
	//create bill
	public Bill createBill(Bill bill) {
		return billDAO.save(bill);
	}
	
	public List<Bill> getBills(){
		return (List<Bill>) billDAO.findAll();
	}

	public List<Bill> findBillByMonth(int month) {
		return billDAO.getByMonth(month);
	}

	
}