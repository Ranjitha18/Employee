package com.employee.demo.service;

import java.util.List;

import com.employee.demo.domain.Employee;
import com.employee.demo.model.EmployeeModel;
import com.employee.demo.response.Response;




public interface IEmployeeService {
	
	public Response addEmployee(EmployeeModel empModel) throws Exception;
	
    public EmployeeModel getEmployeeById(int id) throws Exception;
	
	public List<EmployeeModel> getEmployee() throws Exception;


}
