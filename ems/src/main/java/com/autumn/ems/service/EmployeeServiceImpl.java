package com.autumn.ems.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.autumn.ems.dto.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	public List<Employee> getEmployeesByUpdateDate(Date startDate, Date endDate) {
		
		List<Employee> employees = new ArrayList<Employee>();

		LocalDateTime _startDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime _endDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		while(_startDate.isBefore(_endDate)) {
			int day = _startDate.getDayOfMonth();
			int month = _startDate.getMonthValue();
			int year = _startDate.getYear();
			int hour = _startDate.getHour();
			
			_startDate = _startDate.plusHours(1);
			
			String _emp = String.format("%d%d%d%d", hour,day,month,year);
			
			Employee emp = new Employee();
			emp.setActive(true);
			emp.setAddress(_emp+" mock user address");
			emp.setCreatedDate(_startDate.toString());
			emp.setDesig("Software Developer");
			emp.setEmail(_emp+"@autumn.com");
			emp.setFirstName(_emp);
			emp.setLastName("");
			emp.setFullName(_emp);
			emp.setLogin(_emp);
			emp.setMobile("+91 0000111122");
			
			employees.add(emp);
		}
		
		return employees;
	}
}
