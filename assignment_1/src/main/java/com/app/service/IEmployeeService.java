package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Employee;



public interface IEmployeeService {

	//insert new Employee details
	Employee addEmployeeDetails(Employee transientPOJO);
 
	//list of all Employees
	List<Employee> getAllEmployeeDetails();
	
	//Update existing employee details
	Employee updateEmployeeDetails(Employee detachedPOJO,int employeeId);
	
	//Delete Employee by id 
	Optional<Employee> deleteEmployeeById(int employeeId);
}

