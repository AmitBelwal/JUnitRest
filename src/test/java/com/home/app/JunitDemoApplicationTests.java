package com.home.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.home.app.dao.HomeDAO;
import com.home.app.entity.Employee;
import com.home.app.service.HomeService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JunitDemoApplicationTests {
	
	@Autowired
	private HomeService service;
	
	@MockBean
	private HomeDAO dao;
	
	@Test
	public void getEmployeesTest() {
		Mockito.when(dao.getList()).thenReturn((Stream.of(new Employee(1, "qwer", "asd"), new Employee(2, "qwer1", "asd1")).collect(Collectors.toList())));
		assertEquals(2, service.getList().size());
	}

	@Test
	public void createEmployeeTest() {
		Employee employee = new Employee(100, "rahul", "pandey");
		Mockito.when(dao.saveEmployee(employee)).thenReturn(employee);
		assertEquals(employee, service.saveEmployee(employee));
	}
	
	@Test
	public void getEmployeeTest() {
		int empID = 1;
		Employee employee = new Employee(1, "qwerty","asdfg");
		Mockito.when(dao.employee(empID)).thenReturn(employee);
		assertEquals(employee, service.getEmployee(empID));
	}
	
	@Test
	public void updateEmployeeTest() {
		int empID = 1;
		Employee employee = new Employee(1, "qwerty","asdfg");
		Mockito.when(dao.updateEmployee(employee, empID)).thenReturn(employee);
		assertEquals(employee, service.updateEmployee(employee, empID));
	}
	
	@Test
	public void deleteEmployeeTest() {
		int empID = 1;
		Mockito.when(dao.deleteEmployee(empID)).thenReturn("success");
		assertEquals("success", service.deleteEmployee(empID));
	}
	

}
