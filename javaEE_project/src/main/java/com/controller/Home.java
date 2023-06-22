package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;

import com.dao.auth;
import com.modul.admin;

/**
 * Servlet implementation class Home
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("submit")!= null) {
			
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				boolean acces = auth.logIn(new admin(username,password));
				if(acces) {
				request.getSession().setAttribute("login", username);					 
				response.sendRedirect("flights");
				}
				
				else {
					request.setAttribute("error", new String("error"));
					request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
				}
			
		}
		else {
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}
	}

}
