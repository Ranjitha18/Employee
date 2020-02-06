package com.employee.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.demo.constants.StatusCode;
import com.employee.demo.domain.Employee;
import com.employee.demo.response.Response;
import com.employee.demo.utils.CommonUtils;




@Transactional
@Repository
public class EmployeeDaoImpl implements IEmployeedao {

	@PersistenceContext
	EntityManager entityManager;
	

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public Response addEmployee(Employee emp) throws Exception {
		Response response = CommonUtils.getResponseObject("added");
		try {
			entityManager.persist(emp);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
		
	
	}

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		String hql="From Employee where id=:ab";
		return (Employee) entityManager.createQuery(hql).setParameter("ab", id).getSingleResult();
	}

	@Override
	public List<Employee> getEmployee() throws Exception {
		try {
			List<Employee> listStudentDomain=empRepo.findAll();
			return listStudentDomain;
		
		}catch(Exception e1) {
			System.out.println(e1);
		}
		return null;

	}

}
