package com.revature.util;

import java.util.ArrayList;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAO_jdbc;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public class DbSandbox {

	public static void main(String[] args) {
		EmployeeDAO emDao =new EmployeeDAO_jdbc();
//		Employee test= new Employee();
//		test.setFirstname("test");
//		test.setLastname("testerson");
//		test.setDh_id(1);
//		test.setSu_id(1);
//		test.setEmployeeType(1);
//		test.setE_mail("test@test.test");
//		test.setPassword("test");
//		test.setUsername("tester");
//		test.setReimbursements(new ArrayList<Reimbursement>());
//		emDao.addEmployee(test);
		
		Employee test2 = emDao.getEmployee("tester");
		System.out.println(test2.toString());
	}

}
