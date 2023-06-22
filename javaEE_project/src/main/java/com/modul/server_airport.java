package com.modul;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


public class server_airport extends Thread implements Serializable {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int nb_Avion;
		private int id ;
		private position pos;
		private String name;
		private int nb_voie;
		private int nb_voie_utul=0;
		private int nember_places;
		private ArrayList<avion> avion_depart= new ArrayList<>(nember_places); 
		private HashMap<Integer, Socket> sockets_connected = new HashMap<>();
		


		public boolean canfly() {
			if(this.getNb_voie_utul()<=this.getNb_voie())
			 return true;
			else
			 return false;
		}
		
	    public int getNb_voie_utul() {
			return nb_voie_utul;
		}
		public void increaseNb_voie_utul() {
			this.nb_voie_utul ++;
		}
		public void decreaseNb_voie_utul_() {
			this.nb_voie_utul --;
			synchronized (this) {
				this.notify();
			}
		}
		public int getNb_voie() {
			return nb_voie;
		}
		public void setNb_voie(int nb_voie) {
			this.nb_voie = nb_voie;
		}
		public server_airport(int nb_Avion, int id, position position, String name,
				int nember_places, ArrayList<avion> avion_depart,int nb_voie) {
			super();
			this.nb_Avion = nb_Avion;
			this.id = id;
			this.pos = position;

			this.name = name;
			this.nember_places = nember_places;
			this.avion_depart = avion_depart;
			this.nb_voie=nb_voie;
		}
	    public server_airport( int id, position position, String name) {
			this.id = id;
			this.pos = position;
			this.name = name;
		}
		public position getPosition() {
			return pos;
		}

		public void setPosition(position position) {
			this.pos = position;
		}

		public HashMap<Integer, Socket> getSockets_connected() {
			return sockets_connected;
		}

		public void setSockets_connected(HashMap<Integer, Socket> sockets_connected) {
			this.sockets_connected = sockets_connected;
		}

		public int getNb_Avion() {
			return nb_Avion;
		}

		public void setNb_Avion(int nb_Avion) {
			this.nb_Avion = nb_Avion;
		}

		public int getIdairport() {
			return id;
		}

		public void setIdairport(int id) {
			this.id = id;
		}

		public String getNameairport() {
			return name;
		}

		public void setNameairport(String name) {
			this.name = name;
		}

		public int getNember_places() {
			return nember_places;
		}

		public void setNember_places(int nember_places) {
			this.nember_places = nember_places;
		}

		public ArrayList<avion> getAvion_depart() {
			return avion_depart;
		}

		public void setAvion_depart(ArrayList<avion> avion_depart) {
			this.avion_depart = avion_depart;
		}
		

		public server_airport( int id, String name, int nember_places) {
			super();
			this.id = id;
			this.name = name;
			this.nember_places = nember_places;
		}
		
		public void display() {
			for (Socket s : this.sockets_connected.values()) {
				
				System.out.println(s.getPort());
			}
			
		}

		@Override
	    public void run() {
	        
	        try {
	            System.out.println("opening the airport name's: "+this.name+"  .... ");
	            String socketport = this.id+"00";
	            ServerSocket sc = new ServerSocket(Integer.parseInt(socketport));

	            while(!sc.isClosed()){             	
    	            Socket s =sc.accept();
    	           nb_Avion++;
    	            conversation cs =new conversation(s,nb_Avion);
    	            avion av = cs.recive(new avion());
    	            cs.send(this.name);
    	           sockets_connected.put(av.getId(), s);
    	           
    	           
    	           synchronized (this.getSockets_connected()) {
    	        	   this.getSockets_connected().notify();
				}
    	           
    	           
    	            System.out.println(" airport name s "+this.name+" connected... to the plane  "+av.getId()); 
    	            
                }
                

	            }
	        catch(Exception e) {   	
	        	System.out.println(e);
	        }

	        
	    }
		
		
	    
	    public class conversation  implements Serializable  {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Socket s ;
	        private int id_avion;
	        InputStream inputStream ;
	        OutputStream outputStream ;
	        ObjectOutputStream objectOutputStream ;
	        ObjectInputStream objectInputStream ;
	        
	        

	        public conversation(Socket s,int  id_avion) {
	            this.s = s;
	            this.id_avion=  id_avion;	      
	        }
	        
	        
	        
	        public Socket getS() {
				return s;
			}



			public void setS(Socket s) {
				this.s = s;
			}



			public int getId_avion() {
				return id_avion;
			}



			public void setId_avion(int id_avion) {
				this.id_avion = id_avion;
			}



			public void send (Object object) {
	        	try {
	        	  	outputStream = s.getOutputStream();
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
		        	inputStream = this.s.getInputStream();
		        	objectInputStream = new ObjectInputStream(inputStream);
		        	 new_fly = (T) objectInputStream.readObject();
	        	}
	        	catch(Exception e) {
	        		
	        		System.out.println(e);
	        	}

           return new_fly;
	        	
	        }
	        
	        
	        }
	    

	    
}
	        
	

	        
	    
	    
	    


	    
	    
	




