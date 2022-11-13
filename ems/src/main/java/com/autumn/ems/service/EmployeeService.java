package com.autumn.ems.service;

import java.util.Date;
import java.util.List;

import com.autumn.ems.dto.Employee;

public interface EmployeeService {

	public List<Employee> getEmployeesByUpdateDate(Date startDate, Date endDate);
}
