package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.revature.beans.Event;
import com.revature.util.ConnectionUtil;

public class EventDAO_jdbc implements EventDAO {

	public EventDAO_jdbc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Event getEvent(int id) {
		Event e = new Event();
		PreparedStatement ps = null;
		try(Connection conn=ConnectionUtil.getConn()){
			String sql="select * from event_detail where evt_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				e.setId(rs.getInt("evt_id"));
				e.setLocation(rs.getString("e_location"));
				e.setG_format_id(rs.getInt("g_format_id"));
				e.setWork_time_missed(rs.getInt("work_time_missed"));
				e.setDatetime((Date) rs.getTimestamp("E_DATETIME"));
				e.setName(rs.getString("e_name"));
			}
			rs.close();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Event> getAllEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertEvent(Event e) {
		int newID=-1;
		PreparedStatement ps =null;
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="insert into event_detail(e_location, g_format_id, work_time_missed, e_datetime, e_name) values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql, new String[]{"evt_id"});
			ps.setString(1,e.getLocation());
			ps.setInt(2,e.getG_format_id());
			ps.setInt(3, e.getWork_time_missed());
			ps.setTimestamp(4, new Timestamp(e.getDatetime().getTime()));
			ps.setString(5, e.getName());
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next()) {
				newID=rs.getInt(1);
			}
			ps.close();
			return newID;
		}catch(Exception exp) {
			exp.printStackTrace();
			return newID;
		}
	}

	@Override
	public boolean updateEvent(int id, Event e) {
		// TODO Auto-generated method stub
		return false;
	}

}
