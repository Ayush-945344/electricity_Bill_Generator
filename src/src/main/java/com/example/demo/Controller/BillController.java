package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Bill;
import com.example.demo.Services.BillServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BillController {
	
	@Autowired
	private BillServices billServices;

	@GetMapping("/bills")
	public List<Bill> getAllBills(){
		return billServices.getBills(); 
	}
	
	
	@PostMapping("/bills/create")
	public Bill createBill(@RequestBody Bill bill) {
		return billServices.createBill(bill);
	}
	
	@GetMapping("bills/month/{month}")
	public List<Bill> getMonthlyBill(@PathVariable int month) {
		return billServices.findBillByMonth(month);
	}
	
	

}
