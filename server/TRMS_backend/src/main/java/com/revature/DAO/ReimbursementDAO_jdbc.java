package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAO_jdbc implements ReimbursementDAO {
	private Map<Integer,String> event_type_reference=new HashMap<Integer,String>();
	private Map<String,Integer> event_type_r_reference=new HashMap<String,Integer>();
	private Map<Integer,Double> event_comp_ratio=new HashMap<Integer,Double>();
	private Map<Integer, String> status_reference =new HashMap<Integer,String>();
	private Map<String,Integer> status_r_reference= new HashMap<String,Integer>();
	private void getReference() {
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="select * from event_type";
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				event_type_reference.put(rs.getInt("evt_type_id"), rs.getString("evt_type"));
				event_type_r_reference.put(rs.getString("evt_type"), rs.getInt("evt_type_id"));
				event_comp_ratio.put(rs.getInt("evt_type_id"), rs.getDouble("COMPENSATION_PERCENT"));
			}
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="select * from reimbursement_status";
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				status_reference.put(rs.getInt("s_id"), rs.getString("status"));
				status_r_reference.put(rs.getString("status"), rs.getInt("s_id"));
			}
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ReimbursementDAO_jdbc() {
		getReference();
	}
	
	@Override
	public Reimbursement getReimbursement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		List<Reimbursement> rlist= new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="select r_id, employees.e_id, evt_id, employees.firstname, employees.lastname, e_cost, r_type, r_date, description, justification, status, awarded, admin_reason, urgency from reimbursements join employees on reimbursements.e_id=employees.e_id";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Reimbursement r=new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setEvent_id(rs.getInt("evt_id"));
				r.setEmployee_name(rs.getString("firstname")+" "+rs.getString("lastname"));
				r.setType_id(rs.getInt("r_type"));
				r.setType(event_type_reference.get(rs.getInt("r_type")));
				r.setCost(rs.getDouble("e_cost"));
				r.setRequest_date(rs.getTimestamp("r_date"));
				r.setAwarded(rs.getDouble("awarded"));
				r.setDescription(rs.getString("description"));
				r.setJustification(rs.getString("justification"));
				r.setAdmin_reason(rs.getString("admin_reason"));
				r.setUrgency(rs.getBoolean("urgency"));
				r.setStatus_id(rs.getInt("status"));
				r.setStatus(status_reference.get(rs.getInt("status")));
				rlist.add(r);
			}
			rs.close();
			ps.close();
			return rlist;
		}catch(Exception e) {
			e.printStackTrace();
			return rlist;
		}
	}

	@Override
	public List<Reimbursement> getLimitedReimbursement(int index, int num_records) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByEid(int id) {
		List<Reimbursement> rlist= new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="select r_id, employees.e_id, evt_id, employees.firstname, employees.lastname, e_cost, r_type, r_date, description, justification, status, awarded, admin_reason, urgency from reimbursements join employees on reimbursements.e_id=employees.e_id where employees.e_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Reimbursement r=new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setEvent_id(rs.getInt("evt_id"));
				r.setEmployee_name(rs.getString("firstname")+" "+rs.getString("lastname"));
				r.setType_id(rs.getInt("r_type"));
				r.setType(event_type_reference.get(rs.getInt("r_type")));
				r.setCost(rs.getDouble("e_cost"));
				r.setRequest_date(rs.getTimestamp("r_date"));
				r.setAwarded(rs.getDouble("awarded"));
				r.setDescription(rs.getString("description"));
				r.setJustification(rs.getString("justification"));
				r.setAdmin_reason(rs.getString("admin_reason"));
				r.setUrgency(rs.getBoolean("urgency"));
				r.setStatus_id(rs.getInt("status"));
				r.setStatus(status_reference.get(rs.getInt("status")));
				rlist.add(r);
			}
			rs.close();
			ps.close();
			return rlist;
		}catch(Exception e) {
			e.printStackTrace();
			return rlist;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementByDepartment(int id) {
		List<Reimbursement> rlist= new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="select r_id, e.e_id, evt_id, e.firstname, e.lastname, e_cost, r_type, r_date, description, justification, status, awarded, admin_reason, urgency from reimbursements join employees e on e.e_id=reimbursements.e_id where e.DH_ID=? or e.e_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Reimbursement r=new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setEvent_id(rs.getInt("evt_id"));
				r.setType_id(rs.getInt("r_type"));
				r.setType(event_type_reference.get(rs.getInt("r_type")));
				r.setCost(rs.getDouble("e_cost"));
				r.setEmployee_name(rs.getString("firstname")+" "+rs.getString("lastname"));
				r.setRequest_date(rs.getTimestamp("r_date"));
				r.setAwarded(rs.getDouble("awarded"));
				r.setDescription(rs.getString("description"));
				r.setJustification(rs.getString("justification"));
				r.setAdmin_reason(rs.getString("admin_reason"));
				r.setUrgency(rs.getBoolean("urgency"));
				r.setStatus_id(rs.getInt("status"));
				r.setStatus(status_reference.get(rs.getInt("status")));
				rlist.add(r);
			}
			rs.close();
			ps.close();
			return rlist;
		}catch(Exception e) {
			e.printStackTrace();
			return rlist;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementBySupervisor(int id) {
		List<Reimbursement> rlist= new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="select r_id, e.e_id, evt_id,e.su_id, e.firstname,"
					+ " e.lastname, e_cost, r_type, r_date, description, "
					+ "justification, status, awarded, admin_reason, urgency"
					+ " from reimbursements join (employees e inner join "
					+ "employees s on e.su_id=s.e_id) on e.e_id=reimbursements.e_id where s.e_id=? or e.e_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Reimbursement r=new Reimbursement();
				r.setR_id(rs.getInt("r_id"));
				r.setE_id(rs.getInt("e_id"));
				r.setEvent_id(rs.getInt("evt_id"));
				r.setType_id(rs.getInt("r_type"));
				r.setEmployee_name(rs.getString("firstname")+" "+rs.getString("lastname"));
				r.setType(event_type_reference.get(rs.getInt("r_type")));
				r.setCost(rs.getDouble("e_cost"));
				r.setRequest_date(rs.getTimestamp("r_date"));
				r.setAwarded(rs.getDouble("awarded"));
				r.setDescription(rs.getString("description"));
				r.setJustification(rs.getString("justification"));
				r.setAdmin_reason(rs.getString("admin_reason"));
				r.setUrgency(rs.getBoolean("urgency"));
				r.setStatus_id(rs.getInt("status"));
				r.setStatus(status_reference.get(rs.getInt("status")));
				rlist.add(r);
			}
			rs.close();
			ps.close();
			return rlist;
		}catch(Exception e) {
			e.printStackTrace();
			return rlist;
		}
	}

	@Override
	public int insertReimbursement(Reimbursement request) {
		PreparedStatement ps = null;
		int newID=-1;
		try(Connection conn = ConnectionUtil.getConn()) {
			String sql="insert into reimbursements(e_id, "
					+ "evt_id, e_cost, r_type, r_date, description, "
					+ "justification, status, urgency)"
					+ " values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql, new String[]{"r_id"});
			ps.setInt(1, request.getE_id());
			ps.setInt(2, request.getEvent_id());
			ps.setDouble(3, request.getCost());
			ps.setInt(4, request.getType_id());
			ps.setTimestamp(5, new Timestamp(request.getRequest_date().getTime()));
			ps.setString(6, request.getDescription());
			ps.setString(7, request.getJustification());
			ps.setInt(8,request.getStatus_id());
			ps.setBoolean(9, request.isUrgency());
			ps.executeUpdate();
			ResultSet rs =ps.getGeneratedKeys();
			if(rs.next()){
				newID=rs.getInt(1);
			}
			ps.close();
			return newID;
		}catch(Exception e) {
			e.printStackTrace();
			return newID;
		}
	}

	@Override
	public int updateReimbursementStatus(int id, int newStatus) {
		PreparedStatement ps = null;
		int newID=-1;
		try(Connection conn = ConnectionUtil.getConn()) {
			String sql="update reimbursements set status = ? where r_id = ?";
			ps=conn.prepareStatement(sql, new String[]{"r_id"});
			ps.setInt(1, newStatus);
			ps.setInt(2, id);
			newID=ps.executeUpdate();
			return newID;
		}catch(Exception e) {
			e.printStackTrace();
			return newID;
		}
	}

	@Override
	public boolean updateReimbursement(Reimbursement request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReimbursementStatus(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int updateReimbursementStatus(int id, int newStatus, String reason) {
		PreparedStatement ps = null;
		int newID=-1;
		try(Connection conn = ConnectionUtil.getConn()) {
			String sql="update reimbursements set status = ?, set admin_reason=? where r_id = ?";
			ps=conn.prepareStatement(sql, new String[]{"r_id"});
			ps.setInt(1, newStatus);
			ps.setString(2, reason);
			ps.setInt(3, id);
			ps.executeUpdate();
			ResultSet rs =ps.getGeneratedKeys();
			if(rs.next()){
				newID=rs.getInt(1);
			}
			ps.close();
			return newID;
		}catch(Exception e) {
			e.printStackTrace();
			return newID;
		}
	}

}
