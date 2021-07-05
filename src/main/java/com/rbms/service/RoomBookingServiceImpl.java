package com.rbms.service;


import java.util.ArrayList;
import java.util.List;

import com.rbms.model.Customer;
import com.rbms.repository.RoomBookingRepository;
import com.rbms.service.impl.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {
	
	List<Customer> customers=new ArrayList<Customer>();

	@Autowired
	public RoomBookingRepository roomBookingRepository;
	
	//To get the customer by id
	public Customer getCustomer(Long id) {
		return roomBookingRepository.findById(id).get();
	}
	
	//To save the customer to table
	public Customer addCustomer(Customer customer) {
		return roomBookingRepository.save(customer);
	}
	@Override
	public List<Customer> findAll() {
		return roomBookingRepository.findAll();
	}

	@Override
	public List<Customer> deleteCustomerById(Long customerId){
		roomBookingRepository.deleteById(customerId);
		return roomBookingRepository.findAll();
	}
	@Override
	public void deleteCustomer(Customer customer) {
		roomBookingRepository.delete(customer);
	}

}
