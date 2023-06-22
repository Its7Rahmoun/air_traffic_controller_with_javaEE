package com.modul;

import java.io.Serializable;

public class line_equation implements Serializable {

	private double a;
	private double b;
	public line_equation(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
	
	
}
