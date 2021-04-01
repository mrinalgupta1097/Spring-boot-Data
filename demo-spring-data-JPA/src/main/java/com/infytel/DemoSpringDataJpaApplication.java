package com.infytel;

import com.infytel.dto.CustomerDTO;
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
public class DemoSpringDataJpaApplication implements CommandLineRunner {

	static Logger logger = Logger.getLogger(DemoSpringDataJpaApplication.class);

	@Autowired
	ApplicationContext context;

	@Autowired
	CustomerService service;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(DemoSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CustomerDTO customer1 = new CustomerDTO(7011615820L, "Martha", 27,'G', "Chicago",1);
		CustomerDTO customer2 = new CustomerDTO(7011615829L, "Roddy", 34,'M', "LA",2);
		CustomerDTO customer3 = new CustomerDTO(7011615828L, "Cristie", 51,'G', "Wisconsin",3);

		// invoke service layer method to insert customer

		// flow of application service -> repository -> JpaRepository

		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		service.insertCustomer(customer3);

		logger.info("Records are successfully added");

		System.out.println("Enter the phone number of the customer which has to be deleted");
		Scanner sc = new Scanner(System.in);
		Long phoneNo = sc.nextLong();

		// invoking service layer method to delete customer
		service.removeCustomer(phoneNo);
		logger.info("Record deleted");

		System.out.println("Enter the phone  number of the customer whose details has to be printed");
		Long phoneNo1 = sc.nextLong();
		CustomerDTO customerDTO = service.getCustomer(phoneNo1);
		logger.info("Customer Details");
		logger.info("Phone Number : " + customerDTO.getPhoneNumber());
		logger.info("Name: " + customerDTO.getName());
		logger.info("Address : " + customerDTO.getAddress());
		logger.info("Age : " + customerDTO.getAge());




	}
}
