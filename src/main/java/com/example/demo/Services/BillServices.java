package com.example.demo.Services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.BillDAO;
import com.example.demo.DAO.ConsumerDAO;
import com.example.demo.DAO.GeneratedBillDAO;
import com.example.demo.Entity.Bill;
import com.example.demo.Entity.Consumer;
import com.example.demo.Entity.ConsumerType;
import com.example.demo.Entity.GenerateBillCO;
import com.example.demo.Entity.GenerateBillDTO;

@Service
public class BillServices {
	
	@Autowired
	private static BillDAO billDAO;
	@Autowired
	private GeneratedBillDAO generateBillDAO;
	@Autowired
	private ConsumerDAO consumerDAO;
	
//	create bill
	public Bill createBill(Bill bill) {
		return billDAO.save(bill);
	}
	
	public List<Bill> getBills(){
		return (List<Bill>) billDAO.findAllBills();
	}

	public GenerateBillDTO generateBill(GenerateBillCO generateBillCO) {
		
		Optional<Consumer> consumer=consumerDAO.findById(generateBillCO.getConsumerId());
		GenerateBillDTO resBill=new GenerateBillDTO();
		int amt=0;
		ConsumerType type= consumer.get().getType();
		if(type.equals(ConsumerType.COMMERCIAL))
			 amt=(generateBillCO.getUnits())*4;
		else if(type.equals(ConsumerType.DOMESTIC))
			amt=(generateBillCO.getUnits())*2;
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
		resBill.setBillId(number);
		resBill.setConsumerId(generateBillCO.getConsumerId());
		resBill.setMonth(generateBillCO.getMonth());
		resBill.setYear(generateBillCO.getYear());
		resBill.setUnits(generateBillCO.getUnits());
		resBill.setConsumerName(consumer.get().getConsumerName());
		resBill.setTotalAmount(amt);
		resBill.setType(type);
		generateBillDAO.save(resBill);
		return resBill;
	}

	
}