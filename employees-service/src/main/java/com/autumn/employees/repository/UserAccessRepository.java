package com.autumn.employees.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.autumn.employees.model.UserAccess;

public interface UserAccessRepository extends CrudRepository<UserAccess, Integer>  {

	List<UserAccess> findByEmployeeId(Integer employeeId);

}
