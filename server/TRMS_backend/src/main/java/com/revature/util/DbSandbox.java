package com.revature.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAO_jdbc;
import com.revature.DAO.EventDAO;
import com.revature.DAO.EventDAO_jdbc;
import com.revature.DAO.ReimbursementDAO;
import com.revature.DAO.ReimbursementDAO_jdbc;
import com.revature.beans.Employee;
import com.revature.beans.Event;
import com.revature.beans.Reimbursement;
import com.revature.user.BasicUser;
import com.revature.user.User;

public class DbSandbox {

	public static void main(String[] args) {
		//EmployeeDAO emDao =new EmployeeDAO_jdbc();
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
		//EventDAO eDAO = new EventDAO_jdbc();
//		eDAO.insertEvent(test1);
		//System.out.println(eDAO.getEvent(1).toString());
		//ReimbursementDAO rDAO = new ReimbursementDAO_jdbc();
//		Reimbursement testr = new Reimbursement();
//		testr.setE_id(4);
//		testr.setEvent_id(1);
//		testr.setType_id(2);
//		testr.setAwarded(0);
//		testr.setCost(100.0);
//		testr.setRequest_date(new Date(System.currentTimeMillis()));
//		testr.setDescription("simple course");
//		testr.setJustification("I need it");
//		testr.setStatus_id(1);
//		testr.setUrgency(false);
//		System.out.println(rDAO.insertReimbursement(testr));
//		List<Reimbursement> x=rDAO.getReimbursementByEid(31);
//		System.out.println(x.size());
//		for(Reimbursement i:x) {
//			System.out.println(i.toString());
//		}
//	}
		User usr = new BasicUser(31, new EmployeeDAO_jdbc(), new EventDAO_jdbc(), new ReimbursementDAO_jdbc());
		System.out.println(usr.getEmployee().getE_id());
	}
}