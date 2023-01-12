package com.example.demo.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.ConsumerDAO;
import com.example.demo.Entity.Consumer;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Services.ConsumerServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ConsumerController {
	
	@Autowired
	  private ConsumerServices consumerService;
	
	@Autowired
	  private ConsumerDAO consumerDAO;
		

	// get all employees
		@GetMapping("/consumers")
		public List<Consumer> getAllEmployees(){
			System.out.println("/consumers is invoked...");
			return consumerService.getConsumers();
		}		
		
		// create employee rest api
		@PostMapping("/consumers/create")
		public Consumer createEmployee(@RequestBody Consumer consumer) {
			System.out.println("/consumers/create is invoked...");
			return consumerService.createConsumer(consumer);
		}
		
		// get employee by id rest api
		@GetMapping("/consumers/{id}")
		public Optional<Consumer> getEmployeeById(@PathVariable int id) throws ResourceNotFoundException {
			System.out.println("/consumers{id} is invoked...");
			return consumerDAO.findById(id);
		}
		
		// update employee rest api
		
		@PutMapping("/consumers/update/{id}")
		public Consumer updateEmployee(@PathVariable int id, @RequestBody Consumer consumerDetails){
			System.out.println("/consumers/update/{id} is invoked...");
			return consumerService.updateConsumer(id, consumerDetails);
		}
		
		// delete employee rest api
		@DeleteMapping("/consumers/delete/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws ResourceNotFoundException{
			return ResponseEntity.ok(consumerService.deleteConsumer(id));
		}
}
