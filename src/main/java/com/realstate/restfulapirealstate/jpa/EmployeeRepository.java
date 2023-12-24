package com.realstate.restfulapirealstate.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realstate.restfulapirealstate.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
