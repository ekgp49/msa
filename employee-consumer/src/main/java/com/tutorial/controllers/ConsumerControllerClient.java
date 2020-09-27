package com.tutorial.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial.repository.UserRepository;
import com.tutorial.services.RemoteCallService;

@Controller
public class ConsumerControllerClient {
	
	@Autowired
	private RemoteCallService loadBalancer;

	@Autowired
	private UserRepository memberRepo;
	
	public void getEmployee() throws RestClientException, IOException {
		try {
			Employee emp = loadBalancer.getData();
			System.out.println(emp.toString());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "logout";
	}
}
