package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.EmployeeDAO_jdbc;
import com.revature.DAO.EventDAO_jdbc;
import com.revature.DAO.ReimbursementDAO_jdbc;
import com.revature.beans.Reimbursement;
import com.revature.user.BasicUser;
import com.revature.user.User;

/**
 * Servlet implementation class getReimbursements
 */
@WebServlet("/getReimbursements")
public class getReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getReimbursements() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User usr = new BasicUser(Integer.parseInt(request.getParameter("id")), new EmployeeDAO_jdbc(), new EventDAO_jdbc(), new ReimbursementDAO_jdbc());
		List<Reimbursement>rList=usr.getrList();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(rList);
		response.getWriter().append(json);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
