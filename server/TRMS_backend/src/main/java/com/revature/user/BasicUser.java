package com.revature.user;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EventDAO;
import com.revature.DAO.ReimbursementDAO;

public class BasicUser extends User {

	public BasicUser(int id, EmployeeDAO eDAO, EventDAO evtDAO, ReimbursementDAO rDAO) {
		super(id, eDAO, evtDAO, rDAO);
	}
}
