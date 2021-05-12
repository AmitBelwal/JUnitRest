package com.home.app.dao.com.home.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.home.app.entity.Employee;

@Repository

public class HomeDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Employee> getList() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Employee");
		List<Employee> list = (List<Employee>) query.getResultList();
		session.close();
		return list;
	}
	@Transactional
	public Employee saveEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
        int id = (int) session.save(employee);
        Employee newEmployee = employee(id);
        session.close();
		return newEmployee;
	}
	
	@Transactional
	public Employee updateEmployee(Employee employee, int empID) {
		Session session = entityManager.unwrap(Session.class);	
		session.update(employee);
		Employee getEmployee = employee(empID);
		session.close();
		return getEmployee;
	}
	
	public Employee employee(int empID) {
		Session session = entityManager.unwrap(Session.class);	
		String hql = "from Employee where empID = :empID";    
		Query query = session.createQuery(hql);
		query.setParameter("empID", empID);		
		Employee employee = (Employee) query.getResultList().get(0);
		session.close();
		return employee;
	}
	
	@Transactional
	public String deleteEmployee(int empID) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Employee where empID = :empID");
		query.setParameter("empID", empID);		
		query.executeUpdate();
		session.close();
		return "Success";
	}
	
}
