package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.EmployeeDAO_jdbc;
import com.revature.DAO.EventDAO_jdbc;
import com.revature.DAO.ReimbursementDAO_jdbc;
import com.revature.WEO.webUser;
import com.revature.beans.credentials;
import com.revature.user.BasicUser;
import com.revature.user.User;
import com.revature.user.UserFactory;
import com.revature.util.JWTUtil;

/**
 * Servlet implementation class auth
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/auth" })
public class auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String JWT=null;
		String authHeader = request.getHeader("Authorization");
        if ( authHeader != null && authHeader.startsWith("Bearer ") ) {
            JWT=authHeader.substring( "Bearer ".length());
        }
        if(JWT!=null) {
        	try {
        		credentials c=JWTUtil.parseJWT(JWT);
        		User usr = UserFactory.getUser(c);
        		webUser wb = new webUser(usr.getEmployee().getE_id(),usr.getEmployee().getEmployeeType(),
        				usr.getEmployee().getFirstname(), usr.getEmployee().getLastname(), usr.getrList());
        		ObjectMapper mapper = new ObjectMapper();
        		String json = mapper.writeValueAsString(wb);
        		response.getWriter().append(json);
        	}catch(Exception e){
        		e.printStackTrace();
        		response.getWriter().append("not authorized");
        	}
        	
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
