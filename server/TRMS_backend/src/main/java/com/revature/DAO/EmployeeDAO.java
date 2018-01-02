package com.revature.DAO;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public Employee getEmployee(int id);
	public Employee getEmployee(String userName);
	public List<Employee> getAllEmployee();
	public boolean addEmployee(Employee em);

}
