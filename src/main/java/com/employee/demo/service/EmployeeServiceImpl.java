package com.employee.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.constants.StatusCode;
import com.employee.demo.domain.Employee;
import com.employee.demo.mapper.EmployeeMapper;
import com.employee.demo.model.EmployeeModel;

import com.employee.demo.repository.IEmployeedao;
import com.employee.demo.response.Response;
import com.employee.demo.utils.CommonUtils;





@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeedao empDao;
	
	@Autowired
	EmployeeMapper empMapper;

	@Override
	public Response addEmployee(EmployeeModel empModel) throws Exception {
		
    Response res = CommonUtils.getResponseObject("successfully registered");
		
		try {
		
		Employee emp = new Employee();
		
		BeanUtils.copyProperties(empModel,emp);
		System.out.println("**************added*********************");
		res = empDao.addEmployee(emp);
		res.setStatus(StatusCode.SUCCESS.name());
		return res;
		}
		
		catch(Exception e)
		{
			System.out.println("----------------Exception ----------------------------");
			res.setStatus(StatusCode.ERROR.name());
			
		}
		return res;

	}

	@Override
	public EmployeeModel getEmployeeById(int id) throws Exception {
		try {
			Employee emp=empDao.getEmployeeById(id);
			EmployeeModel empModel = new EmployeeModel();
			
			BeanUtils.copyProperties(emp, empModel);
			return empModel;
			}catch(Exception e) {
			System.out.println(e);
			System.out.println(e);
			}
			return null;
	}

	@Override
	public List<EmployeeModel> getEmployee() throws Exception {
		try {
			List<Employee> emp = empDao.getEmployee();
			List<EmployeeModel> model=empMapper.entityList(emp);
			return model;
			}
			catch(Exception d) {
				System.out.println(d);
			}
		return null;
	}
	
	
	
	

}
