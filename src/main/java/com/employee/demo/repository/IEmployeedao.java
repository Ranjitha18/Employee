package com.employee.demo.repository;

import java.util.List;

import com.employee.demo.domain.Employee;
import com.employee.demo.response.Response;


;

public interface IEmployeedao {
	
	public Response addEmployee(Employee emp) throws Exception;
	
    public Employee getEmployeeById(int id) throws Exception;
	
	public List<Employee> getEmployee() throws Exception;

}
