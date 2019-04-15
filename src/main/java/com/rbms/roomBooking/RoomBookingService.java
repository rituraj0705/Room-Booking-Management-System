package com.rbms.roomBooking;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingService {
	
	List<Customers> customers=new ArrayList<Customers>();

	@Autowired
	public RoomBookingRepository roomBookingRepository;
	
	//To get the customer by id
	public Customers getCustomer(Long id) {
		return roomBookingRepository.findById(id).get();
	}
	
	//To save the customer to table
	public void addCustomer(Customers customer) {
		roomBookingRepository.save(customer);
		customers.add(customer);
		}
	
	//Check whether Customer already exists
	public boolean isCustomerExist(Customers customer) {
		return findByName(customer.getFirstName(),customer.getLastName())!=null;
	}
	
	//find the customer by first name and last name
	public Customers findByName(String firstName,String lastName) {
        for(Customers customer : customers){
            if(customer.getFirstName().equalsIgnoreCase(firstName)&&customer.getLastName().equalsIgnoreCase(lastName)){
                return customer;
            }
        }
        return null;
    }

}
