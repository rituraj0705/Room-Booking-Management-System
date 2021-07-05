package com.rbms.repository;

import com.rbms.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookingRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);
}
