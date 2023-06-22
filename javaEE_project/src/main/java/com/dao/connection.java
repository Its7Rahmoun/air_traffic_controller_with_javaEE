package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	
	
	static Connection cnx;
    static final String jdbcUrl = "jdbc:mysql://localhost:3306/air_traffic_controller";
    static final String username = "root";
     static final String password = "";
	
	public static Connection getcon() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    cnx = DriverManager.getConnection(jdbcUrl, username, password);
		    return cnx;
			
		}
		catch(Exception e ) {
			System.out.println(e);
			return null;
		}
		
		
	}
	

}
