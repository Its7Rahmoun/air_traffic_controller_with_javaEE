package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public class opeartion {
	
	public static void executeData(String query) {
		try {
		Connection cnx = connection.getcon();
		cnx.createStatement().executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static ResultSet getData(String query) {
		try {
		Connection cnx = connection.getcon();
		return cnx.createStatement().executeQuery(query);
		}
		catch(Exception e) {
			
			System.out.println(e);
			return null;
		}
		
		
	}

}
