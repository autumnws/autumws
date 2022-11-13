/**
 * 
 */
package com.autumn.employees.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autumn.employees.config.EmployeesServiceConfig;
import com.autumn.employees.dto.EmployeeDetails;
import com.autumn.employees.model.Employee;
import com.autumn.employees.model.UserAccess;
import com.autumn.employees.repository.EmployeesRepository;
import com.autumn.employees.repository.UserAccessRepository;
import com.autumn.employees.service.client.CardsFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.annotation.Timed;

/**
 * @author Eazy Bytes
 *
 */

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	private EmployeesRepository employeesRepository;

	@Autowired
	private UserAccessRepository userAccessRepository;
	
	@Autowired
	EmployeesServiceConfig employeesServiceConfig;

	@GetMapping("/account/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		return employeesServiceConfig.toString();
	}

	
	@GetMapping("/id/{id}")
	@CircuitBreaker(name = "employeeDetails",fallbackMethod ="employeeDetailsFallBack")
	@Retry(name = "employeeDetailsRetry", fallbackMethod = "employeeDetailsFallBack")
	public EmployeeDetails employeeDetails(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id) {
		
		logger.info("employeeDetails() method started");
		
		EmployeeDetails employeeDetails = new EmployeeDetails();
		Optional<Employee>  emp = employeesRepository.findById(Integer.parseInt(id));
		
		if(emp.isPresent())
			employeeDetails.setEmployee(emp.get());
		
		employeeDetails.setAccess(this.getAllAccessById(correlationid, id));
		
		return employeeDetails;

	}

	private EmployeeDetails employeeDetailsFallBack(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id, Throwable t) {
		return new EmployeeDetails();
	}
	
	@GetMapping("/access/id/{id}")
	@CircuitBreaker(name = "getAllAccessById",fallbackMethod ="getAllAccessByIdFallBack")
	@Retry(name = "getAllAccessByIdRetry", fallbackMethod = "getAllAccessByIdFallBack")
	public List<UserAccess> getAllAccessById(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id) {
		
		logger.info("getAllAccessById() method started");
		
		List<UserAccess> accessList = userAccessRepository.findByEmployeeId(Integer.parseInt(id));
		
		return accessList;
	}

	private List<UserAccess> getAllAccessByIdFallBack(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id, Throwable t) {
		return new ArrayList<UserAccess>();
	}
	
	@GetMapping("/sayHello")
	@RateLimiter(name = "sayHello", fallbackMethod = "sayHelloFallback")
	public String sayHello() {
		return "Hello, Welcome to Autumn Workspace Kubernetes cluster";
	}

	private String sayHelloFallback(Throwable t) {
		return "Hi, Welcome to Autumn Workspace";
	}

}
