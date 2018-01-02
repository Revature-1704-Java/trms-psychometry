package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO_jdbc implements EmployeeDAO {
	
	public EmployeeDAO_jdbc() {	
	}

	@Override
	public Employee getEmployee(int id) {
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return null;
	}

	@Override
	public boolean addEmployee(Employee em) {
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConn()) {
			String sql="insert into employees(firstname"
					+ ", lastname, e_mail, username, password"
					+ ", employeetype) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, em.getFirstname());
			ps.setString(2, em.getLastname());
			ps.setString(3, em.getE_mail());
			//ps.setInt(4, em.getDh_id());
			//ps.setInt(5, em.getSu_id());
			ps.setString(4,em.getUsername());
			ps.setString(5, em.getPassword());
			ps.setInt(6, em.getEmployeeType());
			System.out.println(ps.toString());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee getEmployee(String userName) {
		Employee employee=null;
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConn()){
			String sql="select * from employees where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				employee=new Employee();
				employee.setE_id(rs.getInt("e_id"));
				employee.setE_mail(rs.getString("e_mail"));
				employee.setEmployeeType(rs.getInt("employeetype"));
				employee.setSu_id(rs.getInt("su_id"));
				employee.setDh_id(rs.getInt("dh_id"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setReimbursements(new ArrayList<Reimbursement>());
				employee.setFirstname(rs.getString("firstname"));
				employee.setLastname(rs.getString("lastname"));
			}
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
