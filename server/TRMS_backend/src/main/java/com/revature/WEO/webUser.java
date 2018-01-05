package com.revature.WEO;

import java.util.List;

import com.revature.beans.Reimbursement;

public class webUser {
	private int e_id, employee_type;
	private String firstName, lastName;
	List<Reimbursement> Reimbursements;
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(int employee_type) {
		this.employee_type = employee_type;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Reimbursement> getReimbursements() {
		return Reimbursements;
	}
	public void setReimbursements(List<Reimbursement> reimbursements) {
		Reimbursements = reimbursements;
	}
	public webUser(int e_id, int employee_type, String firstName, String lastName, List<Reimbursement> reimbursements) {
		super();
		this.e_id = e_id;
		this.employee_type = employee_type;
		this.firstName = firstName;
		this.lastName = lastName;
		Reimbursements = reimbursements;
	}
	public webUser() {
	}
}
