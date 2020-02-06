package com.employee.demo.mapper;


import org.springframework.stereotype.Component;

import com.employee.demo.abstractmappee.AbstractModelMapper;
import com.employee.demo.domain.Employee;
import com.employee.demo.model.EmployeeModel;

@Component
public class EmployeeMapper extends  AbstractModelMapper<EmployeeModel,Employee>{

	
	public Class<EmployeeModel> entityType() {
		return EmployeeModel.class;
	}
	
	public Class<Employee> modelType() {
		return Employee.class;
	}
}
