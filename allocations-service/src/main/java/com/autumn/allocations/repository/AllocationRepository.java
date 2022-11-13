package com.autumn.allocations.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.autumn.allocations.model.Allocation;
import com.autumn.allocations.model.Employee;

@Repository
public interface AllocationRepository extends CrudRepository<Allocation, Integer> {

	Optional<Allocation> findById(Integer id);
	
	List<Allocation> findByEmployeeId(Integer employeeId);
	
	@Query("SELECT a FROM Allocation a WHERE a.active = true and a.employeeId = :employeeId")
	List<Allocation> findActiveByEmployeeId(Integer employeeId);
	
}
