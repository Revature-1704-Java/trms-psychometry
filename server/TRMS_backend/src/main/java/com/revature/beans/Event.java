package com.revature.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Event {
	private int id, g_format_id, work_time_missed;
	private Date date, time;
	private String location,name;
	private List<Reimbursement> reimbursements;
	private Map<Integer, String> g_format;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getG_format_id() {
		return g_format_id;
	}
	public void setG_format_id(int g_format_id) {
		this.g_format_id = g_format_id;
	}
	public int getWork_time_missed() {
		return work_time_missed;
	}
	public void setWork_time_missed(int work_time_missed) {
		this.work_time_missed = work_time_missed;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}
	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}
	public Map<Integer, String> getG_format() {
		return g_format;
	}
	public void setG_format(Map<Integer, String> g_format) {
		this.g_format = g_format;
	}
	public Event() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
