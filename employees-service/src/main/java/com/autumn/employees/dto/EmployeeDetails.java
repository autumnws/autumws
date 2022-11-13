package com.autumn.employees.dto;

import java.io.Serializable;
import java.util.List;

import com.autumn.employees.model.Employee;
import com.autumn.employees.model.UserAccess;

public class EmployeeDetails implements Serializable {

	private Employee employee;
	private List<UserAccess> access;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<UserAccess> getAccess() {
		return access;
	}
	public void setAccess(List<UserAccess> access) {
		this.access = access;
	}

	
}
