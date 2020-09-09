package com.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tutorial.model.Employee;

@RestController
public class TestController {

	@GetMapping("/employee")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {
		
		System.out.println("Inside firstPage");
		
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setSalary(3000);
		
		if(emp.getName().equalsIgnoreCase("emp1"))
			throw new RuntimeException();
		
		return emp;
	}
	
	public Employee getDataFallBack() {
		
		System.out.println("Inside fallback");
		
		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId("fallback-1");
		emp.setSalary(3000);

		return emp;
		
	}
}
