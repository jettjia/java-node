package com.atguigu.sssp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atguigu.sssp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee getByLastName(String lastName);
	
}
