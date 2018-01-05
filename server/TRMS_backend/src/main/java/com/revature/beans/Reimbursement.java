package com.revature.beans;

import java.util.Date;

public class Reimbursement {
	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", e_id=" + e_id + ", event_id=" + event_id + ", type_id=" + type_id
				+ ", status_id=" + status_id + ", cost=" + cost + ", awarded=" + awarded + ", urgency=" + urgency
				+ ", description=" + description + ", justification=" + justification + ", admin_reason=" + admin_reason
				+ ", employee_name=" + employee_name + ", type=" + type + ", status=" + status + ", request_date="
				+ request_date + "]";
	}
	private int r_id, e_id, event_id, type_id, status_id;
	private double cost, awarded;
	private boolean urgency;
	private String description, justification, admin_reason, employee_name, type, status;
	private Date request_date;
	public Reimbursement() {
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getAwarded() {
		return awarded;
	}
	public void setAwarded(double awarded) {
		this.awarded = awarded;
	}
	public boolean isUrgency() {
		return urgency;
	}
	public void setUrgency(boolean urgency) {
		this.urgency = urgency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getAdmin_reason() {
		return admin_reason;
	}
	public void setAdmin_reason(String admin_reason) {
		this.admin_reason = admin_reason;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

}
