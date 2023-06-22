package com.dao;

import java.sql.ResultSet;

import com.modul.admin;

public class auth {
	
	
	public static boolean logIn(admin a) {
		String query = "select * from admin where username='"+a.getName()+"' and password='"+a.getPassword()+"'";
		try {
            
			ResultSet rs= opeartion.getData(query) ;
			if(rs.next()) {
				
				return true;
			
			}
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return false;
	}

}
