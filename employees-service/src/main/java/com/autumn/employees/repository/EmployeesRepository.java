package com.autumn.employees.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.autumn.employees.model.Employee;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Integer> {

	Optional<Employee> findById(Integer id);

}
