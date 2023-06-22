package com.modul;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import algo_optimisation.dijkstra.Node;

public class flight implements Serializable,Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private avion plane;
	private int id;
	private String namecompany;
	private String name;
	private String source;
	private String destination;
	private int height;
	private ArrayList<server_airport> escalier ;
	private ArrayList<Node> nodes ;
	
	
	
	
	
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getNamecompany() {
		return namecompany;
	}


	public void setNamecompany(String namecompany) {
		this.namecompany = namecompany;
	}


	public flight(int id ,String source,String destination,String namecompany) {
		this.id=id;
		this.destination=destination;
		this.source=source;
		this.namecompany=namecompany;
	}
	public flight(int id ,avion p ) {
		this.id=id;
		this.plane=p;

	}
	

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	public avion getPlane() {
		return plane;
	}
	public void setPlane(avion plane) {
		this.plane = plane;
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

	
	public flight(avion plane, int id, String name,	ArrayList<server_airport> airports) {
		super();
		this.plane = plane;
		this.id = id;
		this.name = name;
		this.escalier=airports;
	}
	
	
	
	
	public ArrayList<server_airport> getAirports() {
		return escalier;
	}
	public void setAirports(ArrayList<server_airport> airports) {
		this.escalier = airports;
	}
	public flight() {
		super();
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int randomNumber = (int) ((Math.random() * (1 - 0.3)) + 0.3);     
        calendar.add(Calendar.MINUTE, randomNumber);
        Date updatedDate = calendar.getTime();
        System.out.println("Aircraft ID plane: "+ this.plane.getId() +" departure time is : "+updatedDate+" from airpot "+this.getAirports().get(0).getNameairport());
		
		

			
			
			while(true) 
			{
				if(updatedDate.compareTo(new Date())<0) 
				{
					
					
					this.getAirports().get(0).increaseNb_voie_utul();
					if(!this.getAirports().get(0).canfly())
					{
						
						System.out.println("waiting for free place to taking off..");
					}
					
					while(!this.getAirports().get(0).canfly()) {

					}
					
					if(this.getAirports().get(0).canfly()) {
						try {
							Thread.sleep(1000);
						}
						catch(Exception e) {}
					    Random random = new Random();
						this.setHeight(random.nextInt(90000 - 1000 + 1) + 1000);
						this.getPlane().decollage();
						this.getAirports().get(0).decreaseNb_voie_utul_();
						break;
					}
					
					
					
	
					
					
				}
			}
			
			



		
	}
	
	

}
