package com.infytel.service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Page<Customer> findAlL(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return repository.findAll(sort);
    }


}
