package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.beans.credentials;
import com.revature.user.User;
import com.revature.user.UserFactory;
import com.revature.util.JWTUtil;

/**
 * Servlet implementation class postUpdateStatus
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/postUpdateStatus" })
public class postUpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postUpdateStatus() {
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
        		System.out.println(Integer.parseInt(request.getParameter("id")));
        		boolean success=usr.approveRequest(Integer.parseInt(request.getParameter("id")));
        		String res = success ? "success" : "fail";
        		response.getWriter().append(res);
        	}catch(Exception e){
        		e.printStackTrace();
        		response.getWriter().append("not authorized");
        	}
		}else {
			response.getWriter().append("something is wrong");
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
