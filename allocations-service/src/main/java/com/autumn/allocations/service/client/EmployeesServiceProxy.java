package com.autumn.allocations.service.client;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autumn.allocations.dto.EmployeeDetails;


@FeignClient("employees-service")
public interface EmployeesServiceProxy {

	@RequestMapping(method = RequestMethod.GET, value = "/employees/id/{id}", consumes = "application/json")
	EmployeeDetails employeeDetails(@RequestHeader("autumn-workspace-correlation-id") String correlationid,
			@PathVariable String id);
}
