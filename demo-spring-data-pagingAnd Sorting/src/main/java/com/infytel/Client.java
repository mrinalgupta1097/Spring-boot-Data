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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Scanner;

@SpringBootApplication
public class Client implements CommandLineRunner {

	static Logger logger = Logger.getLogger(Client.class);

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

		CustomerDTO customer1 = new CustomerDTO(9458773923L, "Alfred", 47, 'M', "Chicago", 1);
		CustomerDTO customer2 = new CustomerDTO(7021615829L, "Lois", 34, 'G', "LA", 2);
		CustomerDTO customer3 = new CustomerDTO(7067615828L, "Agatha", 51, 'G', "Delhi", 3);
		CustomerDTO customer4 = new CustomerDTO(9011615828L, "Julian", 41, 'M', "Texas", 2);
		CustomerDTO customer5 = new CustomerDTO(5011615828L, "Bernardine", 21, 'G', "Brattford", 1);
		// invoke service layer method to insert customer

		// flow of application service -> repository -> JpaRepository

		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		service.insertCustomer(customer3);
		service.insertCustomer(customer4);
		service.insertCustomer(customer5);

//		int k = (int) (repository.count() / 3);
//		for (int i = 0; i <= k; i++) {
//			Pageable pageable = PageRequest.of(i, 3);
//			logger.info("Records are : ");
//			Iterable<Customer> customer8 = service.findAlL(pageable);
//
//			for (Customer alist : customer8) {
//				logger.info(alist);
//			}
//		}
		logger.info("Sorted records are : ");
		Iterable<Customer> customer8 = service.findAlL(Sort.by(Sort.Direction.DESC, "name"));
		for (Customer alist3 : customer8) {
			logger.info(alist3);
		}
	}
}
