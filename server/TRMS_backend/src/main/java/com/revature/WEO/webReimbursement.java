package com.revature.WEO;

public class webReimbursement {
    webEvent event;
    double cost;
    int type;
    String description;
    String justification;
	public webEvent getEvent() {
		return event;
	}
	public void setEvent(webEvent event) {
		this.event = event;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public webReimbursement(webEvent event, double cost, int type, String description, String justification) {
		super();
		this.event = event;
		this.cost = cost;
		this.type = type;
		this.description = description;
		this.justification = justification;
	}
	public webReimbursement() {
	}

}
