package com.revature.user;

import com.revature.DAO.EmployeeDAO_jdbc;
import com.revature.DAO.EventDAO_jdbc;
import com.revature.DAO.ReimbursementDAO_jdbc;
import com.revature.beans.credentials;

public class UserFactory {
	public static User getUser(credentials c) {
		if(c.getEmployee_type()==1){
			return new BasicUser(c.getE_id(), new EmployeeDAO_jdbc(), new EventDAO_jdbc(), new ReimbursementDAO_jdbc());
		}
		if(c.getEmployee_type()==2){
			return new SupervisorUser(c.getE_id(), new EmployeeDAO_jdbc(), new EventDAO_jdbc(), new ReimbursementDAO_jdbc());
		}
		if(c.getEmployee_type()==3){
			return new DepartmentHeadUser(c.getE_id(), new EmployeeDAO_jdbc(), new EventDAO_jdbc(), new ReimbursementDAO_jdbc());
		}
		if(c.getEmployee_type()==4){
			return new BenCoUser(c.getE_id(), new EmployeeDAO_jdbc(), new EventDAO_jdbc(), new ReimbursementDAO_jdbc());
		}
		return null;
	}

}
