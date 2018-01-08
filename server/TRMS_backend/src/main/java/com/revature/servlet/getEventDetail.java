package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.EventDAO;
import com.revature.DAO.EventDAO_jdbc;
import com.revature.WEO.webEvent;
import com.revature.beans.Event;

/**
 * Servlet implementation class getEventDetail
 */
@WebServlet("/getEventDetail")
public class getEventDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getEventDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventDAO evtDAO= new EventDAO_jdbc();
		int id = Integer.parseInt(request.getParameter("id"));
		Event e= evtDAO.getEvent(id);
		webEvent we= new webEvent(e.getLocation(), e.getDatetime(), e.getG_format_id(), e.getWork_time_missed(), e.getName());
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(we);
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
