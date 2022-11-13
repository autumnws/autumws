package com.autumn.allocations.dto;

import java.io.Serializable;
import java.util.List;

import com.autumn.allocations.model.Allocation;
import com.autumn.allocations.model.Employee;
import com.autumn.allocations.model.Org;
import com.autumn.allocations.model.UserAccess;
import com.autumn.allocations.model.Workspace;
import com.autumn.allocations.model.Request;

public class AllocationDetails implements Serializable {

	private Allocation allocation;
	private EmployeeDetails employee;
	private Workspace workspaces;
	private Org project;
	private Request request;
	
	public Allocation getAllocation() {
		return allocation;
	}
	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}
	public EmployeeDetails getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDetails employee) {
		this.employee = employee;
	}
	public Workspace getWorkspaces() {
		return workspaces;
	}
	public void setWorkspaces(Workspace workspaces) {
		this.workspaces = workspaces;
	}
	public Org getProject() {
		return project;
	}
	public void setProject(Org project) {
		this.project = project;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	
	@Override
	public String toString() {
		return "AllocationDetails [allocation=" + allocation + ", employee=" + employee + ", workspaces=" + workspaces
				+ ", project=" + project + ", request=" + request + "]";
	}
	
	
}
