package com.infytel.service;

import com.infytel.dto.CustomerDTO;

public interface CustomerService {

    void insertCustomer(CustomerDTO customer);
    void removeCustomer(Long phoneNo);
    CustomerDTO getCustomer(Long phoneNo);
    String updateCustomer(Long phoneNo, Integer newPlanId);
}
