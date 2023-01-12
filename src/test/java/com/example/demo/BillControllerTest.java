package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Controller.BillController;
import com.example.demo.DAO.BillDAO;
import com.example.demo.DAO.GeneratedBillDAO;
import com.example.demo.Entity.Admin;
import com.example.demo.Entity.ConsumerType;
import com.example.demo.Entity.GenerateBillCO;
import com.example.demo.Entity.GenerateBillDTO;
import com.example.demo.Services.BillServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BillController.class)
public class BillControllerTest {
	
	@Autowired
	private MockMvc mockMvc; 
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private BillDAO billDAO;
	@MockBean
	private BillServices billServices;
	@MockBean
	private GeneratedBillDAO generatedBillDAO;

	///bills/generate
	@Test
	public void billGenerateTest()throws Exception{
		GenerateBillCO generateBillCO=new GenerateBillCO();
		generateBillCO.setConsumerId(101);
		generateBillCO.setMonth(12);
		generateBillCO.setYear(2012);
		generateBillCO.setUnits(50);
		
		GenerateBillDTO generateBillDTO=new GenerateBillDTO();
		generateBillDTO.setBillId(753451);
		generateBillDTO.setConsumerId(101);
		generateBillDTO.setConsumerName("Varsha");
		generateBillDTO.setMonth(12);
		generateBillDTO.setYear(2012);
		generateBillDTO.setTotalAmount(600);
		generateBillDTO.setUnits(10);
		generateBillDTO.setType(ConsumerType.COMMERCIAL);
		
		when(billServices.generateBill(generateBillCO)).thenReturn(generateBillDTO);
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.post("/bills/generate")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(generateBillCO));
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk());
	}
	///bills/month/{month}
	@Test
	  public void GenerateBillByIdAndYearTest() throws Exception {
	    GenerateBillCO billCO = new GenerateBillCO(101,12,2012,50);
	    
	    GenerateBillDTO generateBillDTO=new GenerateBillDTO();
		generateBillDTO.setBillId(753451);
		generateBillDTO.setConsumerId(101);
		generateBillDTO.setConsumerName("Varsha");
		generateBillDTO.setMonth(12);
		generateBillDTO.setYear(2012);
		generateBillDTO.setTotalAmount(600);
		generateBillDTO.setUnits(10);
		generateBillDTO.setType(ConsumerType.COMMERCIAL);
		
	    when(generatedBillDAO.findByIdAndYear(101,2012)).thenReturn(generateBillDTO);
	 
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.post("/bill/findByIdAndYear")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(billCO));
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk());
	}
	@Test
	public void GenerateBillByIdAndMonthTest() throws Exception {
		GenerateBillCO billCO = new GenerateBillCO(101,12,2012,50);
		
		GenerateBillDTO generateBillDTO=new GenerateBillDTO();
		generateBillDTO.setBillId(753451);
		generateBillDTO.setConsumerId(101);
		generateBillDTO.setConsumerName("Varsha");
		generateBillDTO.setMonth(12);
		generateBillDTO.setYear(2012);
		generateBillDTO.setTotalAmount(600);
		generateBillDTO.setUnits(10);
		generateBillDTO.setType(ConsumerType.COMMERCIAL);
		
		when(generatedBillDAO.findByIdAndMonth(101,12)).thenReturn(generateBillDTO);
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.post("/bill/findByIdAndMonth")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(billCO));
		mockMvc.perform(requestBuilder)
		.andDo(print())
		.andExpect(status().isOk());
	}
@Test
public void GenerateBillByIdAndMonthAndYearTest() throws Exception {
	GenerateBillCO billCO = new GenerateBillCO(101,12,2012,50);
	
	GenerateBillDTO generateBillDTO=new GenerateBillDTO();
	generateBillDTO.setBillId(753451);
	generateBillDTO.setConsumerId(101);
	generateBillDTO.setConsumerName("Varsha");
	generateBillDTO.setMonth(12);
	generateBillDTO.setYear(2012);
	generateBillDTO.setTotalAmount(600);
	generateBillDTO.setUnits(10);
	generateBillDTO.setType(ConsumerType.COMMERCIAL);
	
	when(generatedBillDAO.findByIdAndMonthAndYear(101,12,2012)).thenReturn(generateBillDTO);
	
	RequestBuilder requestBuilder=MockMvcRequestBuilders
			.post("/bill/findByIdAndMonthAndYear")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(objectMapper.writeValueAsString(billCO));
	mockMvc.perform(requestBuilder)
	.andDo(print())
	.andExpect(status().isOk());
}
}
