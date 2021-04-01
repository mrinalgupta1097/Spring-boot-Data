package com.infytel.repository;

import com.infytel.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    // method to insert a customer record
    public void insert(Customer customer);

    // method to remove a customer record from db
    public int remove(Long phoneNo);

    // method to get all the customer details from db
    public List<Customer> getAll();

    // method to update the customer details
    public void update(Long phoneNo, String address);

}
