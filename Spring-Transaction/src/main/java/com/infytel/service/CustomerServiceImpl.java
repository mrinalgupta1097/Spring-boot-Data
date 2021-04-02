package com.infytel.service;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.PlanDTO;
import com.infytel.repository.CustomerRepository;
import com.infytel.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PlanRepository planRepository;

    @Override
    public void insert(CustomerDTO customerDTO) {
        customerRepository.saveAndFlush(CustomerDTO.prepareEntity(customerDTO));

    }

    @Override
    // update pn Customer and Plan table are executed in transaction scope
    public void updateCustomer(CustomerDTO customerDTO) {

        // method to update the current plan in customer table
        customerRepository.customerUpdate(PlanDTO.preparePlanEntity(customerDTO.getPlan()),customerDTO.getPhoneNumber());

        // method to update the new plan details in Plan table
        planRepository.updatePlan(CustomerDTO.prepareEntity(customerDTO).getPlan().getLocalRate(),
                CustomerDTO.prepareEntity(customerDTO).getPlan().getNationalRate(),
                CustomerDTO.prepareEntity(customerDTO).getPlan().getPlanId());

    }
}
