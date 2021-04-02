package com.infytel;


import com.infytel.dto.CustomerDTO;
import com.infytel.dto.PlanDTO;
import com.infytel.service.CustomerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringTransactionApplication implements CommandLineRunner {
	@Autowired
	AbstractApplicationContext context;

	@Autowired
	CustomerService service;

	static Logger logger = Logger.getLogger(SpringTransactionApplication.class);


	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(SpringTransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PlanDTO plan1 = new PlanDTO(1,"INFY_60",60,60);

		CustomerDTO customer1 = new CustomerDTO(6969696969L, "Mary", 27,'F', "Colorado", "INFY", plan1);

		service.insert(customer1);
		logger.info("records are successfully added");

	}
}
