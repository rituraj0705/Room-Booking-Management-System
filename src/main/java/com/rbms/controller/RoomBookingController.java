package com.rbms.controller;

import com.rbms.model.Customer;
import com.rbms.service.impl.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomBookingController {

	@Autowired
	private RoomBookingService roomBookingService;

	//----------------------Add Customer-------------------------
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = roomBookingService.addCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customers/all")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = roomBookingService.findAll();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	//--------------------Retrieve a Customer----------------------------------
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getCustomers(@PathVariable Long id) {
		try{
	        return new ResponseEntity<>(roomBookingService.getCustomer(id), HttpStatus.OK);
	    }catch(Exception ex){
	        String errorMessage;
	        errorMessage = ex + " <==customer not fount";
	        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }	
	}
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Customer>> deleteCustomerById (@PathVariable(value = "id") Long customerId) {
		List<Customer> customers = roomBookingService.deleteCustomerById(customerId);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	@RequestMapping(value = "/customer/remove", method = RequestMethod.POST)
	public void deleteCustomer (@RequestBody Customer customer) {
		roomBookingService.deleteCustomer(customer);
	}
}
