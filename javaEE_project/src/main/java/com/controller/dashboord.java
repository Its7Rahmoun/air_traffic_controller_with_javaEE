package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.flight_management;
import com.modul.flight;
import com.modul.main1_test;

/**
 * Servlet implementation class dashboord
 */
@WebServlet("/dashboord")
public class dashboord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<flight> flights = flight_management.getFlight();
		request.setAttribute("flights", flights);
		request.getRequestDispatcher("WEB-INF/dashboord.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("search") != null) {
			ArrayList<flight> flights = flight_management.getflightbyname(request.getParameter("searchfeild"));
			request.setAttribute("flights", flights);
			request.getRequestDispatcher("WEB-INF/dashboord.jsp").forward(request, response);
			
		}
		
		else if( request.getParameter("submit")!=null ) {
			
			String[] flights = request.getParameterValues("flights");
			main1_test.main(flights);
			request.getRequestDispatcher("WEB-INF/map.html").forward(request, response);
	        			
		}
		else {
			
			request.getRequestDispatcher("WEB-INF/dashboord.jsp").forward(request, response);
		}

	}
	

}
