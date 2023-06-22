package com.modul;

import java.io.Serializable;
import java.util.ArrayList;

public class company implements Serializable {
	
	private int id;
	private String name;
	private ArrayList<flight> flights ;
	
	public company(int id, String name, ArrayList<flight> flights) {
		super();
		this.id = id;
		this.name = name;
		this.flights = flights;
	}
	public company( String name, ArrayList<flight> flights) {
		this.name = name;
		this.flights = flights;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<flight> flights) {
		this.flights = flights;
	}

	public company() {
		super();

	}
	
	 
	

}
