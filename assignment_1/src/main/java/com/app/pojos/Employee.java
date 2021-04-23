package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	@Column(length = 50)
	private String firstName;
	
	@Column(length = 50)
	private String lastName;
	
	
	private String Gender;
	
	@Column(length = 10 , unique=true)
	private String contactNo;
	
	@Column
	private String Address;
	
	@Enumerated(EnumType.STRING)
	private Technology Technology;

	public Employee() {
		super();
	}

	public Employee(Integer iD, String firstName, String lastName, String gender, String contactNo, String address,
			com.app.pojos.Technology technology) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		Gender = gender;
		this.contactNo = contactNo;
		Address = address;
		Technology = technology;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Technology getTechnology() {
		return Technology;
	}

	public void setTechnology(Technology technology) {
		Technology = technology;
	}
	
	
	
}
