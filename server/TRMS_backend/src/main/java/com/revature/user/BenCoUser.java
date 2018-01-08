package com.revature.user;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EventDAO;
import com.revature.DAO.ReimbursementDAO;
import com.revature.beans.Event;
import com.revature.beans.Reimbursement;

public class BenCoUser extends User {

	public BenCoUser(int id, EmployeeDAO eDAO, EventDAO evtDAO, ReimbursementDAO rDAO) {
		super(id, eDAO, evtDAO, rDAO);
		this.rList=rDAO.getAllReimbursement();
	}

	@Override
	public boolean makeRequest(String e_location, int g_format_id, int work_time_missed, Date e_datetime, String e_name,
			double e_cost, int r_type, String description, String justification) {
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
		r.setRequest_date(new Date(System.currentTimeMillis()));
		r.setDescription(description);
		r.setJustification(justification);
		r.setStatus_id(4);
		long days = TimeUnit.MILLISECONDS.toDays(e_datetime.getTime()-System.currentTimeMillis());
		if((int) days<14) {
			r.setUrgency(true);
		}else {
			r.setUrgency(false);
		}
		int r_id=rDAO.insertReimbursement(r);
		return r_id>0&&evt_id>0;
	}

	@Override
	public boolean approveRequest(int id) {
		return rDAO.updateReimbursementStatus(id, 4)>0;
	}

	@Override
	public boolean denyRequest(int id, String reason) {
		return rDAO.updateReimbursementStatus(id, 0, reason)>0;
	}

}
