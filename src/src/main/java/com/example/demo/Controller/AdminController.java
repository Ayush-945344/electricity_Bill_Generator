package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Consumer;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Services.AdminServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminController 
{
	@Autowired
	AdminServices adminService;
	
			//create admin
			@PostMapping("admin/create")			
			public Admin createAdmin(@RequestBody Admin admin)
			{
			return adminService.createAdmin(admin);
			}
			
			// get all consumers
			@GetMapping("admin/getAll/consumers")
			public List<Consumer> getAllConsumers(){
				return adminService.getConsumers();
			}		
			
			// create consumer by admin
			@PostMapping("admin/create/consumers")
			public Consumer createEmployee(@RequestBody Consumer consumer) {
				return adminService.createConsumer(consumer);
			}
			
			@DeleteMapping("admin/delete/consumer/{id}")
			public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws ResourceNotFoundException{
				return ResponseEntity.ok(adminService.deleteConsumer(id));
			}
			
}