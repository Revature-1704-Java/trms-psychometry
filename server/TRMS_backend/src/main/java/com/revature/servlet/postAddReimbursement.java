package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WEO.webReimbursement;
import com.revature.beans.credentials;
import com.revature.user.User;
import com.revature.user.UserFactory;
import com.revature.util.JWTUtil;

/**
 * Servlet implementation class postAddReimbursement
 */
@WebServlet("/postAddReimbursement")
public class postAddReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postAddReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String JWT=null;
		String authHeader = request.getHeader("Authorization");
        if ( authHeader != null && authHeader.startsWith("Bearer ") ) {
            JWT=authHeader.substring( "Bearer ".length());
        }
        if(JWT!=null) {
        	try {
        		credentials c=JWTUtil.parseJWT(JWT);
        		User usr = UserFactory.getUser(c);
        		ObjectMapper mapper = new ObjectMapper();
        		webReimbursement r=mapper.readValue(request.getReader().readLine(), webReimbursement.class);
        		boolean success=usr.makeRequest(r.getEvent().getLocation(), r.getEvent().getG_format_id(),
        				r.getEvent().getWork_time_loss(), r.getEvent().getDatetime(), r.getEvent().getName(), r.getCost(),
        				r.getType(), r.getDescription(), r.getJustification());
        		String res = success ? "success" : "fail";
        		response.getWriter().append(res);
        	}catch(Exception e){
        		e.printStackTrace();
        		response.getWriter().append("not authorized");
        	}
		}
	}
}
