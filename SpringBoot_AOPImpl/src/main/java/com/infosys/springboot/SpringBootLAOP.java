package com.infosys.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infosys.springboot.service.CustomerServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootLAOP {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootLAOP.class, args);
        CustomerServiceImpl service = null;
        service = (CustomerServiceImpl) context.getBean("customerService");
        service.fetchCustomer();
        context.close();


    }


}


