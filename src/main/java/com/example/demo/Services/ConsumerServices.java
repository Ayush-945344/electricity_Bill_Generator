package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.ConsumerDAO;
import com.example.demo.Entity.Consumer;
import com.example.demo.Entity.ConsumerType;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerServices {
	
	@Autowired
	private ConsumerDAO consumerDao;
	
	
	public boolean login(Consumer consumer) {
		System.out.println("login service");
		int counter = 0;
		
		List<Consumer> consumers = (List<Consumer>)consumerDao.findAll();
		for(Consumer con:consumers) {
			if(con.getConsumerId()==(consumer.getConsumerId()) 
					&& con.getPassword().equals(consumer.getPassword())){
				counter++;
				break;
			}
		}
		if(counter>0) {
			return true ;
		}
		else {
			return false;
		}
	}

	public boolean register(Consumer consumer) {
		Consumer con = consumerDao.save(consumer);
		if(con.getConsumerId()==(consumer.getConsumerId())) {
			return true;
		}
		else {
			return false;
		}
	  }
	
	
	//create user
		public Consumer createConsumer(Consumer consumer) {
			return consumerDao.save(consumer);
		} 
		
		
	//get all users
	public List<Consumer> getConsumers() {
		return (List<Consumer>) consumerDao.findAll();
	}
	
//	public List<Consumer> getConsumers() {
//		return consumers;
//	}
	
	
	
	
	
	//update user
	public Consumer updateConsumer(int id, Consumer consumer) {
		Consumer existingConsumer=consumerDao.findById(id).orElse(null);
			existingConsumer.setConsumerId(consumer.getConsumerId());
			existingConsumer.setConsumerName(consumer.getConsumerName());
			existingConsumer.setPassword(consumer.getPassword());
			existingConsumer.setCity(consumer.getCity());
			existingConsumer.setArea(consumer.getArea());
			existingConsumer.setType(consumer.getType());
			return consumerDao.save(existingConsumer);
	}
	
	//delete users by Id
		public String deleteConsumer(int id) {
			consumerDao.deleteById(id);
			return "Item is removed!!"+id; 
			
		}

}
