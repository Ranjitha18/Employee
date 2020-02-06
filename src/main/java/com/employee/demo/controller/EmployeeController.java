package com.employee.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.constants.StatusCode;
import com.employee.demo.domain.Employee;
import com.employee.demo.model.EmployeeModel;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.response.ErrorObject;
import com.employee.demo.response.Response;
import com.employee.demo.service.IEmployeeService;
import com.employee.demo.utils.CommonUtils;




@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	 IEmployeeService empService;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="Application/json")
	public Response addEmployee( @Valid @RequestBody  EmployeeModel  empmodel) throws Exception 
	{
		return empService.addEmployee(empmodel);
		
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET,produces = "Application/json")
	public  @ResponseBody String getEmployee(@PathVariable int id) throws Exception {
		EmployeeModel empModel=empService.getEmployeeById(id);
		Response res = CommonUtils.getResponseObject(" employee found");
		if (empModel==null) {
			ErrorObject err = CommonUtils.getErrorResponse("employee Not Found", "employee Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(empModel);
		}
		return CommonUtils.getJson(res);
		
		
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "Application/json")
	public  String getEmployee() throws Exception {
		List<EmployeeModel> emp= empService.getEmployee();
		Response res = CommonUtils.getResponseObject("List of employees");
		if (emp.isEmpty()) {
			ErrorObject err = CommonUtils.getErrorResponse("employees Not Found", "employees Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(emp);
		}
		return CommonUtils.getJson(res);


}


}
