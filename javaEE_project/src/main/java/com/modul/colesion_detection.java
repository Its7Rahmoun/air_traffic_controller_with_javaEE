package com.modul;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.modul.server_airport.conversation;

public class colesion_detection extends Thread implements Serializable {
	private int id = 9876;
	private Socket s;
	InputStream inputStream;
	OutputStream outputStream;
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
	ArrayList<info_sent> flights = new ArrayList<>();
	



	public void run() {

		try {
			System.out.println("opening the airport the server detection colision pwd......... ");
			ServerSocket sc = new ServerSocket(id);

			while (!sc.isClosed()) {
				
				isCollisionDetected(this.flights,10);
				
				s = sc.accept();
				info_sent plane = this.recive(new info_sent());


				if (plane != null) {
					
					if(this.flights.size()==0) {
						this.flights.add(plane);
					}
					else {
						
						int index = this.isexist(plane);
						
						if(index==-1) {
							this.flights.add(plane);
						}
						else {
							
							this.flights.remove(index);
							this.flights.add(index, plane);
							
							
						}
						
						
					}
					
					
				}
				
				

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	
	
	}
	
	
	public int isexist(info_sent plane) {
		
		Iterator iterator = this.flights.iterator();
		
		while (iterator.hasNext()) {
			info_sent s = (info_sent) iterator.next();

			if (s.getPlaneId() == plane.getPlaneId()) {
				int index = this.flights.indexOf(s);
				return index;
			}

		}
		
		return -1;
		
	} 



	public static void isCollisionDetected(List<info_sent> objectCoordinates, double range) {
		int numObjects = objectCoordinates.size();

		
		Random random = new Random();

		// Check distances between each pair of objects
		for (int i = 0; i < numObjects - 1; i++) {
			info_sent obj1 = objectCoordinates.get(i);
			double x1 = obj1.getPos().getLatitude();
			double y1 = obj1.getPos().getLangitude();
			double z1 = obj1.getPos().getAtitude();

			for (int j = i + 1; j < numObjects; j++) {
				info_sent obj2 = objectCoordinates.get(j);
				double x2 = obj2.getPos().getLatitude();
				double y2 = obj2.getPos().getLangitude();
				double z2 = obj2.getPos().getAtitude();

				// Calculate the distance between the two objects
				double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)+Math.pow(z2-z1, 2));
				

				// Check if the distance is within the specified range
				if (distance <= range) {
					System.out.println(
							"colision detected between position 1 of fly ID: " + obj1.getPlaneId() + " Position ("+x1+","+y1+" ) and position 2 of fly ID : "+obj2.getPlaneId()+" Position ("+x2+","+y2+")");
					System.out.println("distance between the 2 plane is "+distance);
					System.out.println("changing the heght of one of those flight to aviod colision");
					System.out.println("atitude plane  ID " + obj2.getPlaneId() +" has changed to "+random.nextInt(50000));
					 // Collision detected
				}
			}
		}

		 // No collision detected
	}

	
	/*
	public static void colesion_detected(position actual, avion plane) {

		colesion_points.add(new position(86, 211));
		colesion_points.add(new position(42, 46));
		if (plane.getVol().getHeight() == 10000) {

			if (actual.getLangitude() == colesion_points.get(0).getLangitude()
					|| actual.getLangitude() + 1 == colesion_points.get(0).getLangitude()
					|| actual.getLangitude() - 1 == colesion_points.get(0).getLangitude()
					|| actual.getLatitude() + 2 >= colesion_points.get(0).getLatitude()) {

				plane.getVol().setHeight((int) ((Math.random() * (60000 - 15000)) + 15000));
				System.out.println("Possible collision detected..." + "/n"
						+ " changing the Altitude  for this flight that correlates with this aircraft identifier : ID "
						+ plane.getId());

			}

			else if (actual.getLangitude() == colesion_points.get(1).getLangitude()
					|| actual.getLangitude() + 1 == colesion_points.get(1).getLangitude()
					|| actual.getLangitude() - 1 == colesion_points.get(1).getLangitude()
					|| actual.getLatitude() + 2 >= colesion_points.get(1).getLatitude()) {

				plane.getVol().setHeight((int) ((Math.random() * (60000 - 15000)) + 15000));
				System.out.println("Possible collision detected..." + "/n"
						+ " changing the Altitude  for this flight that correlates with this aircraft identifier : ID "
						+ plane.getId());

			}
		}

	}
	
	*/

	public <T> T recive(T a) {
		T new_fly = null;

		try {
			inputStream = this.s.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
			new_fly = (T) objectInputStream.readObject();
		} catch (Exception e) {

			System.out.println(e);
		}

		return new_fly;

	}

}
