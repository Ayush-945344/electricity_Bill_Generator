package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AdminDAO;
import com.example.demo.DAO.ConsumerDAO;
import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Consumer;

@Service
public class AdminServices {
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private ConsumerDAO consumerDao;
	
	public boolean login(Admin admin) {
		System.out.println("login service");
		int counter = 0;
		
		List<Admin> admins = (List<Admin>)adminDAO.findAll();
		for(Admin a: admins) {
			if(a.getAdminId()==(admin.getAdminId()) 
					&& a.getPassword().equals(admin.getPassword())){
				counter++;
				break;
			}
		}
		if(counter>0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean register(Admin admin) {
		Admin ad = adminDAO.save(admin);
		if(ad.getAdminId()==(admin.getAdminId())) {
			return true;
		}
		else {
			return false;
		}
	  }
	public Admin createAdmin(Admin admin) {
		return adminDAO.save(admin);
	} 
	public List<Consumer> getConsumers() {
		return (List<Consumer>) consumerDao.findAll();
	}
	public Consumer createConsumer(Consumer consumer) {
		return consumerDao.save(consumer);
	} 
	public String deleteConsumer(int id) {
		consumerDao.deleteById(id);
		return "Consumer with id "+id+ " has been removed successfully !"; 
		
	}
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return (List<Admin>) adminDAO.findAll();
	}

}
