package com.example.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table (name="consumer")
public class Consumer {
	@Id
	private int consumerId;
//	@Pattern(regexp = "^[a-zA-Z0-9]{6,10}$")
	private String password;
//	@Size(min=3, message="Name should have atleast 3 characters")
	private String consumerName;
//	@NotEmpty
	private String city;
//	@NotEmpty
	private String area;
	
	private ConsumerType type;

	public Consumer() {
		
	}

	public Consumer(int consumerId,  String consumerName, String password,String city, String area, ConsumerType type) {
		super();
		this.consumerId = consumerId;
		this.password = password;
		this.consumerName = consumerName;
		this.city = city;
		this.area = area;
		this.type = type;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public ConsumerType getType() {
		return type;
	}

	public void setType(ConsumerType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", password=" + password + ", consumerName=" + consumerName
				+ ", city=" + city + ", area=" + area + ", type=" + type + "]";
	} 
	
	
	

}
