package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	 
	@Autowired
	private IEmployeeService service;

	public EmployeeController() {
		System.out.println("In constructor of::"+getClass().getName());
	}
	
	
	 @GetMapping
	  public ResponseEntity<?> listAllEmployee(){
		  System.out.println("In list all Employee");
		  List<Employee> emp=service.getAllEmployeeDetails();
		  if(emp.isEmpty())
		  {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(emp,HttpStatus.OK);
	  }
	
	 
	@PostMapping
	public ResponseEntity<?> addEmployeeDetails(@RequestBody Employee e){
		System.out.println("In add Employee Details");
		try {
			Employee saveEmployeeDetails = service.addEmployeeDetails(e);
			return new ResponseEntity<>(saveEmployeeDetails, HttpStatus.OK);	
		}catch(RuntimeException exp) {
			exp.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	
	
	//request  handling method to update existing Employee
	@PutMapping("/{employeeId}")
	public ResponseEntity<?> updateEmployeeDetails(@PathVariable int employeeId,@RequestBody Employee emp)
	{
		System.out.println("in update"+emp);
		try {
			Employee updatedetails=service.updateEmployeeDetails(emp,employeeId);
			return new ResponseEntity<>(updatedetails,HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable int employeeId) {
		System.out.println("in delete emp " + employeeId);
		// check if emp exists
		try {
			Optional<Employee> deletes = service.deleteEmployeeById(employeeId);
			return new ResponseEntity<>(deletes, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	

}
