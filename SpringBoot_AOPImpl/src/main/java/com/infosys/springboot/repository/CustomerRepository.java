package com.infosys.springboot.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.infosys.springboot.DTO.CustomerDTO;

@Repository
public class CustomerRepository {

    List<CustomerDTO> customers = null;


    @PostConstruct
    public void initializer() {
        CustomerDTO customerDTO = new CustomerDTO(2011615827, "Mrinal",
                "mrinalgupta@gmail.com", "delhi");

        customers = new ArrayList<>();
        customers.add(customerDTO);
    }


    // adding the received customer to customer list
    public String createCustomer(CustomerDTO customerDTO) {

        customers.add(customerDTO);
        return "Customer added successfully" + customers.indexOf(customerDTO);
    }

    // returns a list of customer
    public List<CustomerDTO> fetchCustomer() {
        return customers;
    }

    // deletes a customer based on phone number
    public String deleteCustomer(long phoneNumber) {
        String response = "Customer of:" + phoneNumber + "\t does not exist";
        for (CustomerDTO tempCustomer : customers) {
            if (phoneNumber == tempCustomer.getPhoneNo()) {
                customers.remove(tempCustomer);
                response = tempCustomer.getName() + " of phone number " + tempCustomer.getPhoneNo()
                        + " has been removed successfully";
                break;
            }
        }
        return response;
    }

    // updates a customer
    public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) {
        String response = "Customer of:" + phoneNumber + "\t does not exist";
        for (CustomerDTO tempCustomer : customers) {
            if (tempCustomer.getPhoneNo() == phoneNumber) {
                if (tempCustomer.getName() != null) {
                    tempCustomer.setName(customerDTO.getName());
                }
                if (tempCustomer.getAddress() != null) {
                    tempCustomer.setAddress(customerDTO.getAddress());
                }
                customers.set(customers.indexOf(tempCustomer), tempCustomer);
                response = "Customer having phone number" + tempCustomer.getPhoneNo() + " has been updated";
                break;
            }
        }
        return response;

    }

}
