package com.tutorial.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorial.controllers.Employee;

@FeignClient(name="employee-zuul-service")
public interface RemoteCallService {
	
	@RequestMapping(value="/producer/employee", method = RequestMethod.GET) //zuulApplication에서 정한 producer=> url임 Request URL : http://DESKTOP-4D6DM18:8079/producer/employee
	public Employee getData();
}
