package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="generatedBill")
public class GenerateBillDTO {
	  @Id
	  private int billId;
      private int consumerId;
      private String consumerName;
      private int units;
      private int totalAmount;
      private int month;
  	  private int year;
      private ConsumerType type;
      
      public ConsumerType getType() {
		return type;
	}
	public void setType(ConsumerType type) {
		this.type = type;
	}

	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
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
	
	public GenerateBillDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenerateBillDTO(int consumerId, String consumerName, int billId, int units, int totalAmount, int month,
			int year, ConsumerType type) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.billId = billId;
		this.units = units;
		this.totalAmount = totalAmount;
		this.month = month;
		this.year = year;
		this.type = type;
	}
	@Override
	public String toString() {
		return "GenerateBillDTO [consumerId=" + consumerId + ", consumerName=" + consumerName + ", billId=" + billId
				+ ", units=" + units + ", totalAmount=" + totalAmount + ", month=" + month + ", year=" + year
				+ ", type=" + type + "]";
	}
      
      
      
      
      
}
