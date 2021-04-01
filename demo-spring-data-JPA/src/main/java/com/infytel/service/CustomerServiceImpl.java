package com.infytel.service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("customerService")
public class CustomerServiceImpl  implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    @Override
    public void insertCustomer(CustomerDTO customer) {
        repository.saveAndFlush(CustomerDTO.prepareCustomerEntity(customer));
    }

    @Override
    public void removeCustomer(Long phoneNo) {
        repository.deleteById(phoneNo);

    }

    @Override
    public CustomerDTO getCustomer(Long phoneNo) {
        Optional<Customer> optionalCustomer = repository.findById(phoneNo);
        Customer customerEntity = optionalCustomer.get();
        CustomerDTO customerDTO = Customer.prepareCustomerDTO(customerEntity);
        return customerDTO;
    }

    @Override
    public String updateCustomer(Long phoneNo, Integer newPlanId) {
        Optional<Customer> optionalCustomer = repository.findById(phoneNo);
        Customer customerEntity = optionalCustomer.get();
        customerEntity.setPlanId(newPlanId);
        repository.save(customerEntity);
        return "The plan for the customer with phone number: "+ phoneNo + " has been successfully updated";
    }
}
