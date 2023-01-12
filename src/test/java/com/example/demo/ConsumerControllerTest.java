package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.util.Optional;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.example.demo.Controller.AdminController;
import com.example.demo.Controller.ConsumerController;
import com.example.demo.DAO.AdminDAO;
import com.example.demo.DAO.ConsumerDAO;
import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Consumer;
import com.example.demo.Entity.ConsumerType;
import com.example.demo.Services.AdminServices;
import com.example.demo.Services.ConsumerServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ConsumerController.class)
@ExtendWith(SpringExtension.class)
public class ConsumerControllerTest {
	@Autowired
	private MockMvc mockMvc; 
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	ConsumerServices consumerServices;
	@MockBean
	ConsumerDAO consumerDAO;
	@Test
	void testCreateConsumer() throws Exception {
		Consumer consumer=new Consumer(101,"Varsha","varsha@123","Lucknow","Civil Lines",ConsumerType.DOMESTIC);		
		mockMvc.perform(post("/consumers/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(consumer)))
		.andExpect(status().isOk())
		.andDo(print());
		System.out.println("Success");
	}
	@Test
	  public void testGetConsumerById() throws Exception {
	    Optional<Consumer> consumer = Optional.of(new Consumer(101,"Varsha","varsha@123","Lucknow","Civil Lines",ConsumerType.DOMESTIC));
	 
	    when(consumerDAO.findById(1)).thenReturn(consumer);
	 
	    mockMvc.perform(get("/consumers/1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.consumerId").value(101))
      .andExpect(jsonPath("$.consumerName").value("Varsha"))
      .andExpect(jsonPath("$.password").value("varsha@123"));
	    }
	@Test
	public void testDeleteConsumerById() throws Exception
	{
		mockMvc.perform(delete("/consumers/delete/{id}",1))
		.andExpect(status().isOk());
	}

}
