package com.autumn.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_access")
public class UserAccess {

	@Id
	private Integer id;
	
	@Column(name = "employee_id")
	private Integer employeeId;
	
	private String module;
	
	private String access;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "is_active")
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserAccess [id=" + id + ", employeeId=" + employeeId + ", module=" + module + ", access=" + access
				+ ", createdDate=" + createdDate + ", active=" + active + "]";
	}
	
	
}
