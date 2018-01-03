package com.revature.beans;

public class credentials {
	private int e_id, employee_type;

	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public credentials() {
		super();
	}
	public credentials(int e_id, int employee_type) {
		super();
		this.e_id = e_id;
		this.employee_type = employee_type;
	}
	public int getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(int employee_type) {
		this.employee_type = employee_type;
	}

}
