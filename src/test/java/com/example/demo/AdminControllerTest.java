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
import com.example.demo.DAO.AdminDAO;
import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Consumer;
import com.example.demo.Entity.ConsumerType;
import com.example.demo.Services.AdminServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AdminController.class)
@ExtendWith(SpringExtension.class)
public class AdminControllerTest {
	
	@Autowired
	private MockMvc mockMvc; 
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private AdminDAO adminDAO;
	@MockBean	
	private AdminServices adminServices ;
	@Before                          
	void setUp() { 
		Admin a1=new Admin(1,"Varsha","varsha@123");
		Admin a2=new Admin(2,"Amit","admin123");
		Admin a3=new Admin(3,"Nidhi","nidhi@123");
	}
	
	@Test
	public void testDeleteConsumerById() throws Exception
	{
		mockMvc.perform(delete("/admin/delete/consumer/{id}",1))
		.andExpect(status().isOk());
	}
	@Test
	  void testCreateAdmin() throws Exception {
	    	Admin admin = new Admin(3,"Varsha","varsha@123");

	    mockMvc.perform(post("/admin/create").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(admin)))
	        .andExpect(status().isOk())
	        .andDo(print());
	    System.out.println("Success");
	  }
	@Test
	void testCreateConsumer() throws Exception {
		Consumer consumer=new Consumer(101,"Varsha","varsha@123","Lucknow","Civil Lines",ConsumerType.DOMESTIC);		
		mockMvc.perform(post("/admin/create/consumers").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(consumer)))
		.andExpect(status().isOk())
		.andDo(print());
		System.out.println("Success");
	}
	@Test
	  public void testGetAdminById() throws Exception {
	    Optional<Admin> admin = Optional.of(new Admin(1,"Varsha", "varsha@123"));
	 
	    when(adminDAO.findById(1)).thenReturn(admin);
	 
	    mockMvc.perform(get("/admin/1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.adminId").value(1))
        .andExpect(jsonPath("$.adminName").value("Varsha"))
        .andExpect(jsonPath("$.password").value("varsha@123"));
	    }
//	@Test
//	  void testGetAllAdmins() throws Exception {
//	    List<Admin> adminList = new ArrayList<>(
//	        Arrays.asList(new Admin(1,"Varsha","varsha@123"),
//			new Admin(2,"Amit","admin123"),
//			new Admin(3,"Nidhi","nidhi@123")));
//	    
//	    when(adminDAO.findAll()).thenReturn(adminList);
//	    mockMvc.perform(MockMvcRequestBuilders.get("/admin/getAll/admin"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//	        .andExpect(jsonPath("$.*").value(adminList.size()))
//	        .andDo(print());
//	  }
	
}
