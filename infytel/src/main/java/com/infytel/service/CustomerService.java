package com.infytel.service;

import com.infytel.dto.CustomerDTO;
import com.infytel.entity.Customer;

import java.util.List;

public interface CustomerService {

    // method to access the repository layer method to insert Customer record
    public void insert(CustomerDTO customer);

    //method ton access the repository layer method to delete Customer record
    public int remove(Long phoneNo);

    // method to access the repository layer method to read all the
    // Customer record from db
    public List<CustomerDTO> getAll();

    // method to access the repository layer method to update the customer details
    public void update(Long phoneNo, String address);
}
