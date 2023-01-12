package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bills")
public class Bill {
	
	@Id
	private int billId;
	
	@ManyToOne
	private Consumer consumer;
	
	private int month;
	
	private int year;
	
	private int unitsConsumed;
	
	private int totalAmount;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int billId, Consumer consumer, int month, int year, int unitsConsumed, int totalAmount) {
		super();
		this.billId = billId;
		this.consumer = consumer;
		this.month = month;
		this.year = year;
		this.unitsConsumed = unitsConsumed;
		this.totalAmount = totalAmount;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", consumer=" + consumer + ", month=" + month + ", year=" + year
				+ ", unitsConsumed=" + unitsConsumed + ", totalAmount=" + totalAmount + "]";
	}

	
}