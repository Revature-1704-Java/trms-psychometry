package com.revature.WEO;

import java.util.Date;

public class webEvent {
    String location;
    Date datetime;
    int g_format_id;
    int work_time_loss;
    String name;
	public webEvent() {
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getG_format_id() {
		return g_format_id;
	}
	public void setG_format_id(int g_format_id) {
		this.g_format_id = g_format_id;
	}
	public int getWork_time_loss() {
		return work_time_loss;
	}
	public void setWork_time_loss(int work_time_loss) {
		this.work_time_loss = work_time_loss;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public webEvent(String location, Date datetime, int g_format_id, int work_time_loss, String name) {
		super();
		this.location = location;
		this.datetime = datetime;
		this.g_format_id = g_format_id;
		this.work_time_loss = work_time_loss;
		this.name = name;
	}

}
