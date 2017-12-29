package com.revature.beans;

import java.util.List;

public class Employee {
	private int e_id, dh_id, su_id, employeeType;
	private String firstname, lastname, e_mail, username, password;
	private List<Reimbursement> reimbursements;
	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public int getDh_id() {
		return dh_id;
	}

	public Employee(int e_id, int dh_id, int su_id, int employeeType, String firstname, String lastname, String e_mail,
			String username, String password, List<Reimbursement> reimbursements) {
		super();
		this.e_id = e_id;
		this.dh_id = dh_id;
		this.su_id = su_id;
		this.employeeType = employeeType;
		this.firstname = firstname;
		this.lastname = lastname;
		this.e_mail = e_mail;
		this.username = username;
		this.password = password;
		this.reimbursements = reimbursements;
	}

	public Employee(int e_id, int dh_id, int su_id, int employeeType, String firstname, String lastname, String e_mail,
			String username, String password) {
		super();
		this.e_id = e_id;
		this.dh_id = dh_id;
		this.su_id = su_id;
		this.employeeType = employeeType;
		this.firstname = firstname;
		this.lastname = lastname;
		this.e_mail = e_mail;
		this.username = username;
		this.password = password;
	}

	public void setDh_id(int dh_id) {
		this.dh_id = dh_id;
	}

	public int getSu_id() {
		return su_id;
	}

	public void setSu_id(int su_id) {
		this.su_id = su_id;
	}

	public int getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", dh_id=" + dh_id + ", su_id=" + su_id + ", employeeType=" + employeeType
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", e_mail=" + e_mail + ", username="
				+ username + ", password=" + password + ", reimbursements=" + reimbursements + "]";
	}

}

