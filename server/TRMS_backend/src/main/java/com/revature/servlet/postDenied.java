package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.WEO.webReimbursement;
import com.revature.beans.credentials;
import com.revature.user.User;
import com.revature.user.UserFactory;
import com.revature.util.JWTUtil;

/**
 * Servlet implementation class postDenied
 */
@WebServlet("/postDenied")
public class postDenied extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postDenied() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
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
        		String reason = request.getReader().readLine(); 
        		User usr = UserFactory.getUser(c);
        		boolean success=usr.denyRequest(Integer.parseInt(request.getParameter("id")), reason);
        		String res = success ? "success" : "fail";
        		response.getWriter().append(res);
        	}catch(Exception e){
        		e.printStackTrace();
        		response.getWriter().append("not authorized");
        	}
		}else {
			response.getWriter().append("something is wrong");
		}
        response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
