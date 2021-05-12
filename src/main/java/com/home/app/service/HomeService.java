package com.home.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.app.dao.com.home.app.dao.HomeDAO;
import com.home.app.entity.Employee;

@Service
public class HomeService {
	
	@Autowired
	private HomeDAO repo;
	
	public List<Employee> getList(){
		List<Employee> empList = repo.getList();
		return empList;
	}
	
	public Employee saveEmployee(Employee employee) {
		Employee newEmployee = repo.saveEmployee(employee);		
		return newEmployee;
	}
	
	public Employee getEmployee(int empID) {
		Employee employee = repo.employee(empID);
		return employee;
	}
	
	public String deleteEmployee(int empID) {
		String message = repo.deleteEmployee(empID);
		return message;		
	}
	
	public Employee updateEmployee(Employee employee, int empID) {
		Employee newEmployee = repo.updateEmployee(employee, empID);
		return newEmployee;
	}

}
