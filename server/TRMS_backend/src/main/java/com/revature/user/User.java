package com.revature.user;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EventDAO;
import com.revature.DAO.ReimbursementDAO;
import com.revature.beans.Employee;
import com.revature.beans.Event;
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
	private EventDAO evtDAO;
	private ReimbursementDAO rDAO;
	public User(int id, EmployeeDAO eDAO, EventDAO evtDAO, ReimbursementDAO rDAO) {
		this.eDAO=eDAO;
		this.evtDAO=evtDAO;
		this.rDAO=rDAO;
		this.employee=this.eDAO.getEmployee(id);
		this.rList=this.rDAO.getReimbursementByEid(id);
	}
	public boolean makeRequest(String e_location, int g_format_id, int work_time_missed,
			Date e_datetime, String e_name, double e_cost, int r_type, String description,
			String justification, boolean urgency){
		Event e=new Event();
		e.setLocation(e_location);
		e.setG_format_id(g_format_id);
		e.setWork_time_missed(work_time_missed);
		e.setDatetime(e_datetime);
		e.setName(e_name);
		int evt_id=evtDAO.insertEvent(e);
		Reimbursement r = new Reimbursement();
		r.setE_id(employee.getE_id());
		r.setEvent_id(evt_id);
		r.setCost(e_cost);
		r.setType_id(r_type);
		r.setDescription(description);
		r.setJustification(justification);
		r.setStatus_id(1);
		long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis()-e_datetime.getTime());
		if((int) days<14) {
			r.setUrgency(true);
		}else {
			r.setUrgency(false);
		}
		int r_id=rDAO.insertReimbursement(r);
		return r_id>0&&evt_id>0;
	}

}
