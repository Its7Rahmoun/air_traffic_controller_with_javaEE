package com.modul;

import java.net.Socket;



public class alive_conversation_server implements Runnable {
	
	private server_airport server=null;
	
	
	
	public server_airport getServer() {
		return server;
	}



	public void setServer(server_airport server) {
		this.server = server;
	}



	public alive_conversation_server(server_airport server) {
		super();
		this.server = server;
		try {
			synchronized (this.getServer()) 
            {
				this.getServer().notify();;
			}
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		
		
	}
		}






			
			@Override
			public void run() {

				try {

					Thread.sleep(1000);
				}
				
				catch(Exception e) {
					System.out.println(e);
				}
				
				if(this.getServer().getSockets_connected().size()==0) {
					try {
						synchronized (this.getServer().getSockets_connected()) 
                        {
							this.getServer().getSockets_connected().wait();
						}
						
					}catch(Exception e) {}
					
					while(true) {
						
						for (Socket s1 : this.getServer().getSockets_connected().values()) {
							
							//s1 = mh5.getSockets_connected().get(0);
							server_airport.conversation cn =  this.getServer().new conversation(s1, 0);
							info_sent a = cn.recive(new info_sent());
							System.out.println("latitude : "+a.getPos().getLatitude()+" and longitude : "+a.getPos().getLangitude()+" ID  plane is: "+a.getPlaneId());
							
						}
						
						/*
						Socket s1 = this.getServer().getSockets_connected().get(0);
						server_airport.conversation cn =  this.getServer().new conversation(s1, 0);
						info_sent a = cn.recive(new info_sent());	
						System.out.println("latitude : "+a.getPos().getLatitude()+" and longitude : "+a.getPos().getLangitude()+" plane is'S: "+a.getPlaneId());
						*/
					}

				}
				else {
					
					while(true) {
						for (Socket s1 : this.getServer().getSockets_connected().values()) {
							
							//s1 = mh5.getSockets_connected().get(0);
							server_airport.conversation cn =  this.getServer().new conversation(s1, 0);
							info_sent a = cn.recive(new info_sent());
							System.out.println("latitude : "+a.getPos().getLatitude()+" and longitude : "+a.getPos().getLangitude()+" ID  plane is: "+a.getPlaneId());
							
						}

					}
					
				}

				
			}
		
		

}
