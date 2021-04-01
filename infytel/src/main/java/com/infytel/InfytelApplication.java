package com.infytel;


import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;


@SpringBootApplication
public class InfytelApplication implements CommandLineRunner {

    static Logger logger = Logger.getLogger(InfytelApplication.class);

    @Autowired
    AbstractApplicationContext context;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(InfytelApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        CustomerService service = (CustomerService) context.getBean("customerService");

        CustomerDTO customer1 = new CustomerDTO(8750389115L, "Barry", 27, 'M', "BBSR", 1);
        CustomerDTO customer2 = new CustomerDTO(8750367115L, "Bruce", 37, 'M', "Pune", 2);
        CustomerDTO customer3 = new CustomerDTO(8750419115L, "Diana", 17, 'G', "Delhi", 3);

        service.insert(customer1);
        service.insert(customer2);
        service.insert(customer3);
        logger.info("Records are successfully added..");








    }
}
