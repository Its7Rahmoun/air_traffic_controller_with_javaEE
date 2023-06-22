package com.modul;



import java.io.IOException;
import java.util.Random;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Semaphore;



public class avion_conversation implements Runnable,Serializable  {
	
	private avion plane;
	private Socket socket;
	private Socket socket_colision_detection;
	private   String add_server_colision_detection="127.0.0.1";
	private  int port_server_colision_detection=9876;
	private String add;
	private int port;
	private OutputStream outputStream=null;
	private InputStream inputStream =null; 
	private ObjectOutputStream objectOutputStream=null;
	private ObjectInputStream objectInputStream =null;
	private double x_position ;
	private double y_position;
	private position actualPosition;
	Random random = new Random();
	
	
	

	public Socket getSocket_colision_detection() {
		return socket_colision_detection;
	}

	public void setSocket_colision_detection(Socket socket_colision_detection) {
		this.socket_colision_detection = socket_colision_detection;
	}

	public String getAdd_server_colision_detection() {
		return add_server_colision_detection;
	}

	public void setAdd_server_colision_detection(String add_server_colision_detection) {
		this.add_server_colision_detection = add_server_colision_detection;
	}

	public int getPort_server_colision_detection() {
		return port_server_colision_detection;
	}

	public void setPort_server_colision_detection(int port_server_colision_detection) {
		this.port_server_colision_detection = port_server_colision_detection;
	}

	public position getActualPosition() {
		return actualPosition;
	}

	public void setActualPosition(position actualPosition) {
		this.actualPosition = actualPosition;
	}

	public avion_conversation(avion plane,String add,int port) {
		super();
		this.plane = plane;
		this.add=add;
		this.port= port;
	}
	
	public line_equation  equations_line(position a1,position a2) {

		double a = (a1.getLangitude()-a2.getLangitude())/(a1.getLatitude()-a2.getLatitude());
		double b = a1.getLangitude()-(a*a1.getLatitude());	
		
	return new line_equation(a, b);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.socket= new Socket(this.add,this.port);
			//this.socket_colision_detection= new Socket(this.add_server_colision_detection,this.port_server_colision_detection);
			System.out.println("plane id 's: "+this.plane.getId()+" to airport : connecting ..... ");
			System.out.println("plane id 's: "+this.plane.getId()+" to server colision detection pwd : connecting ..... ");
			this.send(new avion(plane));
			String nameairport = this.recive(new String());
			x_position =0;
		//	y_position;
			int a;
			int nb_of_escalier= plane.getVol().getAirports().size();
			
			for (a=0;a<nb_of_escalier-1;a++) {
				
				line_equation equation = this.equations_line(plane.getPos_of_airport(a), plane.getPos_of_airport(a+1));
	            x_position = plane.getPos_of_airport(a).getLatitude();
				y_position = plane.getPos_of_airport(a).getLangitude();
				

				
				while(true) {
					
					if(equation.getA()<0) {
						if(plane.getPos_of_airport(a).getLangitude()>plane.getPos_of_airport(a+1).getLangitude()) {
							x_position+=1;
							y_position = equation.getA()*x_position+equation.getB();
							actualPosition= new position(x_position, y_position);
							this.plane.setActual_position(actualPosition);
							if(random.nextInt(2)==1) {
								this.socket_colision_detection= new Socket(this.add_server_colision_detection,this.port_server_colision_detection);
							
								this.send_to_server_colision_detection(new info_sent( new position(x_position, y_position,this.plane.getVol().getHeight()),this.plane.getId()));
								
							}
							this.send(new info_sent( new position(x_position, y_position),new Integer(this.plane.getId())));	
						}	
						else if(plane.getPos_of_airport(a).getLangitude()<plane.getPos_of_airport(a+1).getLangitude()) {
							x_position-=1;
							y_position = equation.getA()*x_position+equation.getB();
							actualPosition= new position(x_position, y_position);
							this.plane.setActual_position(actualPosition);
							if(random.nextInt(2)==1) {
								this.socket_colision_detection= new Socket(this.add_server_colision_detection,this.port_server_colision_detection);
								
								this.send_to_server_colision_detection(new info_sent( new position(x_position, y_position,this.plane.getVol().getHeight()),this.plane.getId()));
								
							}
							this.send(new info_sent( new position(x_position, y_position),this.plane.getId()));	
						}
					}
					else if (equation.getA()>0) {
						if(plane.getPos_of_airport(a).getLangitude()<plane.getPos_of_airport(a+1).getLangitude()) {
							x_position+=1;
							y_position = equation.getA()*x_position+equation.getB();
							actualPosition= new position(x_position, y_position);
							this.plane.setActual_position(actualPosition);
							if(random.nextInt(2)==1) {
								this.socket_colision_detection= new Socket(this.add_server_colision_detection,this.port_server_colision_detection);
								
								this.send_to_server_colision_detection(new info_sent( new position(x_position, y_position,this.plane.getVol().getHeight()),this.plane.getId()));
								
							}
							this.send(new info_sent( new position(x_position, y_position),this.plane.getId()));	
						}	
						else if(plane.getPos_of_airport(a).getLangitude()>plane.getPos_of_airport(a+1).getLangitude()) {
							x_position-=1;
							y_position = equation.getA()*x_position+equation.getB();
							actualPosition= new position(x_position, y_position);
							this.plane.setActual_position(actualPosition);
							if(random.nextInt(2)==1) {
								this.socket_colision_detection= new Socket(this.add_server_colision_detection,this.port_server_colision_detection);
								
								this.send_to_server_colision_detection(new info_sent( new position(x_position, y_position,this.plane.getVol().getHeight()),this.plane.getId()));
								
							}
							this.send(new info_sent( new position(x_position, y_position),this.plane.getId()));	
						}
					}
					else {
						if(plane.getPos_of_airport(a).getLangitude()>plane.getPos_of_airport(a+1).getLatitude()) {
							x_position-=1;
							actualPosition= new position(x_position, y_position);
							this.plane.setActual_position(actualPosition);
							if(random.nextInt(2)==1) {
								this.socket_colision_detection= new Socket(this.add_server_colision_detection,this.port_server_colision_detection);
								
								this.send_to_server_colision_detection(new info_sent( new position(x_position, y_position,this.plane.getVol().getHeight()),this.plane.getId()));
								
							}
							this.send(new info_sent( new position(x_position, y_position),this.plane.getId()));	
							
						}
						else {
							x_position+=1;
							actualPosition= new position(x_position, y_position);
							this.plane.setActual_position(actualPosition);
							if(random.nextInt(2)==1) {
								this.socket_colision_detection= new Socket(this.add_server_colision_detection,this.port_server_colision_detection);
								this.send_to_server_colision_detection(new info_sent( new position(x_position, y_position,this.plane.getVol().getHeight()),this.plane.getId()));
							}
							this.send(new info_sent( new position(x_position, y_position),this.plane.getId()));	
						}
					}

				    
					try {
						Thread.sleep(200);
					}
					catch(Exception e) {}

					
					if((int)y_position==(int)plane.getPos_of_airport(a+1).getLangitude() || (int)y_position+1==(int)plane.getPos_of_airport(a+1).getLangitude()|| (int)y_position-1==(int)plane.getPos_of_airport(a+1).getLangitude() || (int)plane.getPos_of_airport(a+1).getLatitude()==(int)(x_position) ) {
						
						//maphore semaphore = new Semaphore(1);
 
				        
						try {
					        int min = 5;
					        int max = 1;
					        int r = (int) ((Math.random() * (max - min)) + max)*100;
							Thread.sleep(r);
						}
						catch(Exception e) {}
						

				            
	
	                        int nb_voie = this.plane.getVol().getAirports().get(a+1).getNb_voie();
	                        int nb_voie_utul = this.plane.getVol().getAirports().get(a+1).getNb_voie_utul();
	                        System.out.println("plane ID : "+ this.plane.getId() +"------>> Number of runways available is "+(nb_voie-nb_voie_utul));	
	                        this.plane.getVol().getAirports().get(a+1).increaseNb_voie_utul();
							
							
		                       if(!this.plane.getVol().getAirports().get(a+1).canfly()) {
		                    	   System.out.println( "plane id : "+this.plane.getId()+" rolling in circule until got a free place for landing..");
		                    	   	synchronized (this.plane.getVol().getAirports().get(a+1)) {
		                    	   		try {
											this.plane.getVol().getAirports().get(a+1).wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
		                       }
							
							
							
							
		                       if(this.plane.getVol().getAirports().get(a+1).canfly()) {
		                    	   
		                    	   
		   						System.out.println(" plane id's: "+plane.getId()+"  came to airport :  "+plane.getVol().getAirports().get(a+1).getNameairport());
		   						//this.send(new Integer(-1));
		   						

		   						
		   						if(plane.getVol().getAirports().size()-1==a+1) {
		   							System.out.println("plane ID : "+this.plane.getId()+" final station :  "+plane.getVol().getAirports().get(a+1).getNameairport());
		   							this.plane.getVol().getAirports().get(a+1).decreaseNb_voie_utul_();
		   							break;
		   						}
		   						else if(plane.getVol().getAirports().size()-1>a+1) {
		   							
		   					        Date date = new Date();
		   					        Calendar calendar = Calendar.getInstance();
		   					        calendar.setTime(date);
		   					        int randomNumber = (int) ((Math.random() * (1 - 0.3)) + 0.3);     
		   					        calendar.add(Calendar.MINUTE, randomNumber);
		   					        Date updatedDate = calendar.getTime();
		   					        System.out.println("Aircraft ID plane : "+plane.getId()+" departure from "+plane.getVol().getAirports().get(a+1).getNameairport()+" time is : "+updatedDate);
		   							

		                              while(updatedDate.compareTo(new Date())>0) {
		                              }
		                              
		                           	   
		                           	this.plane.getVol().getAirports().get(a+1).decreaseNb_voie_utul_();  
		      							System.out.println(" plane ID "+plane.getId()+" moving to the next  airport :  "+plane.getVol().getAirports().get(a+2).getNameairport());
		      							this.port=Integer.parseInt(plane.getVol().getAirports().get(a+2).getIdairport() +"00");
		      							this.socket= new Socket(this.add,this.port);
		      							System.out.println("plane id 's: "+this.plane.getId()+" to airport : connecting ..... ");
		      							this.send(new avion(plane));
		      							break;
		                           	   

		                              

		   						}
		   						

		   							
					
					}
					
					}
					
				}
				
				
				}
			}
			

					

		 catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public <T> void  send (T object){
    	try {
    	  	outputStream = this.socket.getOutputStream();
        	objectOutputStream = new ObjectOutputStream(outputStream);
        	objectOutputStream.writeObject(object);
    		
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
  
    	
    }
	
	public <T> void  send_to_server_colision_detection (T object){
    	try {
    	  	outputStream = this.socket_colision_detection.getOutputStream();
        	objectOutputStream = new ObjectOutputStream(outputStream);
        	objectOutputStream.writeObject(object);
    		
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
  
    	
    }
	
    public <T> T recive(T a ) { 
    	T new_fly=null;
    	
    	try {
        	inputStream = this.socket.getInputStream();
        	objectInputStream = new ObjectInputStream(inputStream);
        	 new_fly = (T) objectInputStream.readObject();
    	}
    	catch(Exception e) {
    		
    		System.out.println(e);
    	}

   return new_fly;
    	
    }

}
