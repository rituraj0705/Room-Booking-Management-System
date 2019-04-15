package com.rbms;


import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;

import com.rbms.roomBooking.Customers;
import com.rbms.roomBooking.RoomBookingController;
import com.rbms.roomBooking.RoomBookingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RoomBookingController.class)
public class RoomBookingManagementSystemApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RoomBookingService roomBookingService;
		
	@PostMapping("/customer")
	@Test
	public void addCustomer() throws Exception {
		
		String exampleCustomerJson= "{\n" + 
				"	\"firstName\" : \"Ravi Rjaj\",\n" + 
				"	\"lastName\": \"Singkh\",\n" + 
				"	\"dob\": \"1996-07-11\",\n" + 
				"	\"email\": \"ravi@gmail.com\",\n" + 
				"	\"password\": \"passwordRavi\"\n" + 
				"}\n" + 
				"}";
		

		// Send course as body to /customer
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/customer")
				.accept(MediaType.APPLICATION_JSON).content(exampleCustomerJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(201, response.getStatus());

		//assertEquals("http://localhost:8080/customer",response.getHeader(HttpHeaders.LOCATION));

	}

	@Test
	public void contextLoads() {
	}

}
