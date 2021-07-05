package com.rbms.service.impl;

import com.rbms.model.Customer;

import java.util.List;

public interface RoomBookingService {
    public Customer getCustomer(Long id);
    public Customer addCustomer(Customer customer);

    List<Customer> findAll();

    List<Customer> deleteCustomerById(Long customerId);

    void deleteCustomer(Customer customer);
}
