package com.revature.DAO;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	public Reimbursement getReimbursement(int id);
	public List<Reimbursement> getAllReimbursement();
	public List<Reimbursement> getLimitedReimbursement(int index, int num_records);
	public List<Reimbursement> getReimbursementByEid(int id);
	public List<Reimbursement> getReimbursementByDepartment(int department_id);
	public List<Reimbursement> getReimbursementBySupervisor(int id);
	public boolean insertReimbursement(Reimbursement request);
	public boolean updateReimbursementStatus(int id, int newStatus);
	public boolean updateReimbursement(Reimbursement request);
	public boolean deleteReimbursementStatus(int id);
}
