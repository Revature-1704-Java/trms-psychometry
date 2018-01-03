package com.revature.util;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAO_jdbc;
import com.revature.DAO.EventDAO;
import com.revature.DAO.EventDAO_jdbc;
import com.revature.beans.Employee;
import com.revature.beans.Event;
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
		
//		Employee test2 = emDao.getEmployee("tester");
//		System.out.println(test2.toString());
//		Event test1 = new Event();
//		test1.setLocation("my house");
//		test1.setG_format_id(1);
//		test1.setDatetime(new Date(System.currentTimeMillis()));
//		test1.setName("test");
//		test1.setWork_time_missed(10);
		EventDAO eDAO = new EventDAO_jdbc();
//		eDAO.insertEvent(test1);
		System.out.println(eDAO.getEvent(1).toString());
		
	}

}
