package com.rbms.roomBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomBookingController {

	@Autowired
	private RoomBookingService roomBookingService;
	
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
	
	//----------------------Add Customer-------------------------
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customers customer) {
		if(roomBookingService.isCustomerExist(customer)) {
            return new ResponseEntity<>("Customer already exists",HttpStatus.BAD_REQUEST);
        }
		else if(customer.getPassword().length()<8) {
			return new ResponseEntity<>("Password length should be atlease of 8 digit",HttpStatus.BAD_REQUEST);
		}
		roomBookingService.addCustomer(customer); 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
		//roomBookingService.addCustomer(customer);		
	}
	
	
}
