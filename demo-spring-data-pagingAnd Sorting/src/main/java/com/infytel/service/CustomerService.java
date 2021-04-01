package com.infytel.service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CustomerService {

    void insertCustomer(CustomerDTO customer);
    Page<Customer> findAlL(Pageable page);
    Iterable<Customer> findAll(Sort sort);
}
