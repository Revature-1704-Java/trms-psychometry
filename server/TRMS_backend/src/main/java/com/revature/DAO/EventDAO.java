package com.revature.DAO;

import java.util.List;

import com.revature.beans.Event;

public interface EventDAO {
	public Event getEvent(int id);
	public List<Event> getAllEvent();
	public boolean insertEvent(Event e);
	public boolean updateEvent(int id, Event e);
}
