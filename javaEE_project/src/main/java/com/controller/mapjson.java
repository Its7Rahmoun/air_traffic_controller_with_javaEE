package com.controller;

import java.io.IOException;
import java.io.*;
import org.json.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mapjson
 */
@WebServlet("/mapjson")
public class mapjson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mapjson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/map.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	      try {
	            // Read the JSON data from the request body
	            StringBuilder requestData = new StringBuilder();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                requestData.append(line);
	            }

	            // Parse the JSON data
	            JSONObject jsonData = new JSONObject(requestData.toString());

	            // Access the JSON properties
	            String lineContent = jsonData.getString("line");

	            // Process the JSON data as needed
	            System.out.println("Received line: " + lineContent);
	            System.out.println("Received line: " + lineContent);
	            System.out.println("Received line: " + lineContent);

	            // Send a response (optional)
	            response.setContentType("text/plain");
	            response.setCharacterEncoding("UTF-8");
	            response.getWriter().write("JSON data received and processed successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            response.getWriter().write("Failed to process the JSON data");
	        }
    }
		
	}


