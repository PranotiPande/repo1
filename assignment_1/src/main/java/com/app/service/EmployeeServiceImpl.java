package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IEmployeeDao;
import com.app.pojos.Employee;


@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeDao dao;

	@Override
	public Employee addEmployeeDetails(Employee transientPOJO) {
		System.out.println("In Employee details save method");
		return dao.save(transientPOJO);
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		return dao.findAll();
	}

	@Override
	public Employee updateEmployeeDetails(Employee e1, int employeeId) {
		System.out.println("In Employee service impl updaate");
				Optional<Employee> e = dao.findById(employeeId);
				if (e.isPresent()) {
					Employee emp = e.get();
					emp.setFirstName(e1.getFirstName());
					emp.setLastName(e1.getLastName());
					emp.setAddress(e1.getAddress());
					emp.setContactNo(e1.getContactNo());
					emp.setTechnology(e1.getTechnology());
					return emp;
				}
				System.out.println("Employee not found");
				return null;
	}

	@Override
	public Optional<Employee> deleteEmployeeById(int employeeId) {
		// check if Employee exist
		Optional<Employee> emp = dao.findById(employeeId);
		System.out.println("From service "+emp);
		if (emp.isPresent()) {
			dao.deleteById(employeeId);
			return emp;
		} 
		System.out.println("Employee not found");
		return null;
		
	}
	
	
	
	
}
