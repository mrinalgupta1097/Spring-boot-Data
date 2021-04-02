package com.infytel.service;

import com.infytel.dto.CustomerDTO;

public interface CustomerService {
    // method nto access the repository layer method to insert Customer record
    public void insert(CustomerDTO customerDTO);

    // method to update a Customer record into the db
    public void updateCustomer(CustomerDTO customerDTO);
}
