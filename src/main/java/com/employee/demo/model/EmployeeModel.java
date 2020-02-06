package com.employee.demo.model;

public class EmployeeModel {

	
	private int id;
	private String emp_name;
	private String gender;
	private long phone_num;
	private String address;
	
	public int getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
	}
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
