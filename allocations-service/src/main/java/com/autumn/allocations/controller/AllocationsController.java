/**
 * 
 */
package com.autumn.allocations.controller;

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

import com.autumn.allocations.config.AllocationsServiceConfig;
import com.autumn.allocations.dto.AllocationDetails;
import com.autumn.allocations.model.Allocation;
import com.autumn.allocations.model.Employee;
import com.autumn.allocations.model.UserAccess;
import com.autumn.allocations.repository.AllocationRepository;
import com.autumn.allocations.service.client.EmployeesServiceProxy;
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
@RequestMapping("/allocations")
public class AllocationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AllocationsController.class);

	@Autowired
	private AllocationRepository allocationRepository;
	
	@Autowired
	private AllocationsServiceConfig allocationsServiceConfig;

	@Autowired
	private EmployeesServiceProxy employeesService;
	
	
	@GetMapping("/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		return allocationsServiceConfig.toString();
	}

	
	@GetMapping("/allocation/{id}")
	@CircuitBreaker(name = "allocationDetails",fallbackMethod ="allocationDetailsFallBack")
	@Retry(name = "allocationDetailsRetry", fallbackMethod = "allocationDetailsFallBack")
	public AllocationDetails allocationDetails(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id) {
		
		logger.info("allocationDetails() method started");
		
		AllocationDetails allocationDetails = new AllocationDetails();
		Optional<Allocation>  _allocation = allocationRepository.findById(Integer.parseInt(id));
		
		Allocation allocation = null;
		
		if(_allocation.isPresent())
			allocation = _allocation.get();
		
		allocationDetails.setAllocation(allocation);
		if(allocation != null)
			allocationDetails.setEmployee(employeesService.employeeDetails( correlationid, allocation.getEmployeeId().toString()));
		
		return allocationDetails;
	}

	private AllocationDetails allocationDetailsFallBack(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id, Throwable t) {
		return new AllocationDetails();
	}
	
	@GetMapping("/employee/{id}")
	@CircuitBreaker(name = "getAllAllocationsByEmployeeId",fallbackMethod ="getAllAllocationsByEmployeeIdFallBack")
	@Retry(name = "getAllAllocationsByEmployeeIdRetry", fallbackMethod = "getAllAllocationsByEmployeeIdFallBack")
	public List<Allocation> getAllAllocationsByEmployeeId(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id) {
		
		logger.info("getAllAllocationsByEmployeeId() method started");
		
		List<Allocation> accessList = allocationRepository.findByEmployeeId(Integer.parseInt(id));
		
		return accessList;
	}

	private List<Allocation> getAllAllocationsByEmployeeIdFallBack(
			@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id, Throwable t) {
		return new ArrayList<Allocation>();
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
