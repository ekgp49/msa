package com.tutorial;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestClientException;

import com.tutorial.controllers.ConsumerControllerClient;

@SpringBootApplication
@EnableFeignClients
class ConsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(ConsumerApplication.class, args);
		
//		ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
//		System.out.println(consumerControllerClient);
//		consumerControllerClient.getEmployee();
		
	}
	
}
