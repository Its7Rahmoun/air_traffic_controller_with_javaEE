package com.modul;

import java.io.Serializable;

public class position implements Serializable {
	
	private double latitude;//cordoone x
	private double longitude;//y
	private double atitude;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLangitude() {
		return longitude;
	}
	public void setLangitude(double langitude) {
		this.longitude = langitude;
	}
	public position(double latitude, double langitude) {
		super();
		this.latitude = latitude;
		this.longitude = langitude;
	}
	
	public position(double latitude, double langitude,double atutude) {
		super();
		this.latitude = latitude;
		this.longitude = langitude;
		this.atitude=atutude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getAtitude() {
		return atitude;
	}
	public void setAtitude(double atitude) {
		this.atitude = atitude;
	}
	
	
	

}
