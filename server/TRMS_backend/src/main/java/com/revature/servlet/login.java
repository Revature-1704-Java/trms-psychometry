package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAO_jdbc;
import com.revature.beans.Employee;
import com.revature.util.JWTUtil;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
	    EmployeeDAO eDao=new EmployeeDAO_jdbc();
	    Employee user=eDao.getEmployee(username);
	    String sys_pass=request.getReader().readLine();
	    if(user.getPassword().equals(sys_pass)) {
	    	ObjectMapper mapper = new ObjectMapper();
		    String json= mapper.writeValueAsString(user);
		    String jwt = JWTUtil.createToken(user.getE_id(), user.getEmployeeType());
		    json=json.replace("}", ",\"token\":\""+jwt+"\"}");
		    response.getWriter().write(json);
	    }else{
	    	response.getWriter().write("{\"login\":"+false+"}");
	    }
	    response.getWriter().close();
	}


}
