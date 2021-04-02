package com.infytel;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;
import com.infytel.service.CustomerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Client implements CommandLineRunner {

	static Logger logger = Logger.getLogger(Client.class);

	@Autowired
	ApplicationContext context;

	@Autowired
	CustomerRepository repository;

	@Autowired
	CustomerService service;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerDTO customer1 = new CustomerDTO(9634431374L, "Steve", 47, 'M', "Chicago", 1);
		CustomerDTO customer2 = new CustomerDTO(3528276442L, "Natasha", 34, 'G', "LA", 2);
		CustomerDTO customer3 = new CustomerDTO(9412536048L, "Bucky", 51, 'M', "Delhi", 3);

		// invoke service layer method to insert customer

		// flow of application service -> repository -> JpaRepository

		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		service.insertCustomer(customer3);

		Iterable<Customer> cus = service.getCustomer("Chicago");
		for(Customer alist : cus){
			logger.info(alist);
		}
	}
}
