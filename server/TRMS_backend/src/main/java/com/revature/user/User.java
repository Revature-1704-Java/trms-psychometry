package com.revature.user;

import java.util.Date;
import java.util.List;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EventDAO;
import com.revature.DAO.ReimbursementDAO;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public abstract class User {
	protected Employee employee;
	protected List<Reimbursement> rList;
	protected EmployeeDAO eDAO;
	public Employee getEmployee() {
		return employee;
	}
	public List<Reimbursement> getrList() {
		return rList;
	}
	protected EventDAO evtDAO;
	protected ReimbursementDAO rDAO;
	public User(int id, EmployeeDAO eDAO, EventDAO evtDAO, ReimbursementDAO rDAO) {
		this.eDAO=eDAO;
		this.evtDAO=evtDAO;
		this.rDAO=rDAO;
		this.employee=this.eDAO.getEmployee(id);
		this.rList=this.rDAO.getReimbursementByEid(id);
	}
	public abstract boolean makeRequest(String e_location, int g_format_id, int work_time_missed,
			Date e_datetime, String e_name, double e_cost, int r_type, String description,
			String justification);
	public abstract boolean approveRequest(int id);
	public abstract boolean denyRequest(int id, String reason);

}
