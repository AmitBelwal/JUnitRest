package com.home.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.app.entity.Employee;
import com.home.app.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService service;	
	
	
	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		List<Employee> employeeList = service.getList();
		return employeeList;
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(Employee employee) {
		Employee newEmployee = service.saveEmployee(employee);
		return newEmployee;
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable(value = "id") int empID) {
		Employee employee = service.getEmployee(empID);
		return employee;
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") int empID, Employee employee) {
		Employee newEmployee = service.updateEmployee(employee, empID);	
		return newEmployee;		
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int empID) {
		String message = service.deleteEmployee(empID);
		return message;		
	}

}
