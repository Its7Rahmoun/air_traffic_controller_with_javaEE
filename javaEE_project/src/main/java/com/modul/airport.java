package com.modul;

import java.io.Serializable;

public class airport implements Serializable  {
	private int id ;
	private String name;
	private int nember_pistes;
	private int nember_places;
	public airport(int id, int nember_places) {
		super();
		this.id = id;
		this.nember_places = nember_places;
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
	public int getNember_pistes() {
		return nember_pistes;
	}
	public void setNember_pistes(int nember_pistes) {
		this.nember_pistes = nember_pistes;
	}
	public int getNember_places() {
		return nember_places;
	}
	public void setNember_places(int nember_places) {
		this.nember_places = nember_places;
	}
	
	
	

}
