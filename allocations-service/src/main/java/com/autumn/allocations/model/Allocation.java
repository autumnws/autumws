package com.autumn.allocations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "allocations")
public class Allocation {
	
	@Id
	private Integer id;

	@Column
	private Integer spaceId;
	
	private Integer employeeId;
	
	@Column(name = "project_id")
	private Integer projectId;
	
	private String type;
	
	@Column(name = "request_id")
	private Integer requestId;
	
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "created_date")
	private String createdDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(Integer spaceId) {
		this.spaceId = spaceId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", spaceId=" + spaceId + ", employeeId=" + employeeId + ", projectId="
				+ projectId + ", type=" + type + ", requestId=" + requestId + ", active=" + active + ", createdDate="
				+ createdDate + "]";
	}

	
}
