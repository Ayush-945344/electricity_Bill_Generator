package com.example.demo.Entity;

public class GenerateBillCO {
	private int consumerId;
	private int month;
	private int year;
	private int units;
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
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
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public GenerateBillCO(int consumerId, int month, int year, int units) {
		super();
		this.consumerId = consumerId;
		this.month = month;
		this.year = year;
		this.units = units;
	}
	public GenerateBillCO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GenerateBillCO [consumerId=" + consumerId + ", month=" + month + ", year=" + year + ", units=" + units
				+ "]";
	}
	
}
