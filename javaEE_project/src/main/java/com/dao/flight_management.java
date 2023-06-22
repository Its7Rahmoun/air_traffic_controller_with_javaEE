package com.dao;

import java.util.ArrayList;
import java.sql.ResultSet;

import com.modul.*;

public class flight_management {
	
	public static ArrayList<flight> getFlight(){
		ArrayList<flight> flights = new ArrayList<>();
		String query ="select flight.id,source,distination,company.name from flight,company,ligne_company_flight "
				+ " where flight.id=ligne_company_flight.id_flight and ligne_company_flight.id_company=company.id ";
		
		try {
			ResultSet rs = opeartion.getData(query);
			
			while(rs.next()) {
			
				flights.add(new flight(rs.getInt("flight.id"),rs.getString("source"),rs.getString("distination"),rs.getString("company.name")));
				
			}
			return flights;
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	public static ArrayList<flight> getflightbyname(String name) {
		//String query = "select * from flight where source like '%"+name+"%' ";
		
		ArrayList<flight> flights = new ArrayList<>();
		//ArrayList<company> companys = new ArrayList<>();
		String query ="select flight.id,source,distination,company.name from flight,company,ligne_company_flight "
				+ " where flight.id=ligne_company_flight.id_flight and ligne_company_flight.id_company=company.id and (source like '%"+name+"%' or distination like '%"+name+"%')";
		
		try {
			ResultSet rs = opeartion.getData(query);
			
			while(rs.next()) {
			
				flights.add(new flight(rs.getInt("flight.id"),rs.getString("source"),rs.getString("distination"),rs.getString("company.name")));
				
			}
			return flights;
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
