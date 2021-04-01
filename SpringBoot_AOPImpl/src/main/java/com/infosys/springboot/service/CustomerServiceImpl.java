package com.infosys.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.springboot.DTO.CustomerDTO;
import com.infosys.springboot.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer(CustomerDTO customerDTO) {
        return customerRepository.createCustomer(customerDTO);

    }

    @Override
    public List<CustomerDTO> fetchCustomer() {
        return customerRepository.fetchCustomer();
    }

    @Override
    public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) {
        return customerRepository.updateCustomer(phoneNumber, customerDTO);
    }

    @Override
    public String deleteCustomer(long phoneNumber) {
        return customerRepository.deleteCustomer(phoneNumber);
    }

}
