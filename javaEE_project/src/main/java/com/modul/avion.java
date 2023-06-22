package com.modul;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import algo_optimisation.dijkstra.Node;

public class avion implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String type;
	private float consomation;//km par L
	private float capacite;
	private flight vol;
	private position actual_position;
	
	//private ArrayList<server_airport> escalier=new ArrayList<>() ;
	
	
	public position getActual_position() {
		return actual_position;
	}



	public void setActual_position(position actual_position) {
		this.actual_position = actual_position;
	}



	public flight getVol() {
		return vol;
	}



	public void setVol(flight vol) {
		this.vol = vol;
	}



	public Boolean can_complete_target(List<Node> nodes) {
		float max_km = this.capacite*(this.consomation);
		int distance;
		for(int i =1;i<nodes.size();i++) {
			
			distance = Math.abs(nodes.get(i).getDistance()-nodes.get(i-1).getDistance());
			if(max_km < distance) {
				return false;
			}
			
		}
		return true;
	}
	
	
	
	public position getPos_of_airport(int escalenumb ) {
		return this.vol.getAirports().get(escalenumb).getPosition();
	}
	public avion(int id, String type, float consomation, float capacite) {
		super();
		this.id = id;
		this.type = type;
		this.consomation = consomation;
		this.capacite = capacite;

	}
	
	public void decollage() {
		if(this.getVol().getNodes().size()!=0) {
			
			if(this.can_complete_target(this.getVol().getNodes())) {
				int port = Integer.parseInt(this.getVol().getAirports().get(1).getIdairport()+"00");
				avion_conversation ac = new avion_conversation(this, "127.0.0.1",port);
				Thread t1 = new Thread(ac);
				t1.start();
			}
			else {
				
				System.out.println("can't fly because the aircraft cannot satisfy the needs");
			}
			
		}
		
		else {
			
			System.out.println("this plane has no flight");
		}
		
		
	}
	public void remove_previous_socketserver_airport(int privious ) {
		
		this.getVol().getAirports().remove(privious);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getConsomation() {
		return consomation;
	}
	public void setConsomation(float consomation) {
		this.consomation = consomation;
	}
	public float getCapacite() {
		return capacite;
	}
	public void setCapacite(float capacite) {
		this.capacite = capacite;
	}

	public avion(avion plane) {
		super();
		this.id = plane.getId();
		this.type = plane.getType();
		this.consomation = plane.getConsomation();
		this.capacite = plane.getCapacite();
		
	}
	
	
	public avion() {
	}

	
	

}
