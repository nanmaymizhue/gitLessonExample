package com.intern.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")
@SequenceGenerator(name="seq",initialValue=1,allocationSize=100)

public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	long id;
	
	@Column(name="TEACHER_NAME")
	String name;
	
	@Column(name="TEACHER_DEPARTMENT")
	String department;
	
	@Column(name="TEACHER_EMAIL")
	String email;
	
	@Column(name="TEACHER_ADDRESS")
	String address;
	
	@Column(name="TEACHER_PHONE")
	String phone;
	

	public Teacher() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
