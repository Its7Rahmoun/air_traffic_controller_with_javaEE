package com.modul;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algo_optimisation.dijkstra.Dijkstra;
import algo_optimisation.dijkstra.Node;
import algo_optimisation.max_flow.FordFulkerson;
import algo_optimisation.max_flow.Vertex;

public class main1_test {
	
	public static int return_node(ArrayList<Node> airports,String name) {
		
		for(Node sa : airports) {
			
			String source = sa.getNameairport_from_node();
			if(source.equals(name)) {
				return airports.indexOf(sa);
			}
	
		}
		
		return -1;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
            colesion_detection cl = new colesion_detection();
            new Thread(cl).start();
            
         
            //create airports 
            ArrayList <server_airport> airports = new ArrayList<>();
            
			server_airport mh5 = new server_airport(11, new position(59.32523459858819,-71.23572694899525),"USA");	
			mh5.setNember_places(20);
			mh5.setNb_voie(1);
			mh5.start();
			airports.add(mh5);
			server_airport mh6 = new server_airport(23, new position(9.596206264795654,-61.21619569899525),"brazil");
			mh6.setNember_places(5);
			mh6.setNb_voie(3);
			mh6.start();
			airports.add(mh6);
			server_airport mh7 = new server_airport(20, new position(32.613385859779015,7.514273051004752),"tunisia");
			mh7.setNember_places(10);
			mh7.setNb_voie(2);
			mh7.start();
			airports.add(mh7);
			server_airport mh8 = new server_airport(21, new position(28.557421153272568,
					43.19786680100475),"Arabie saoudite");
			
			mh8.setNember_places(7);
			mh8.setNb_voie(6);
			mh8.start();
			airports.add(mh8);
			server_airport mh9 = new server_airport(30, new position(28.431900191894602,104.89708555100475),"China");
			mh9.setNember_places(8);
			mh9.setNb_voie(7);
			mh9.start();
			airports.add(mh9);
			server_airport mh10 = new server_airport(24, new position(69.65781652872529,146.20567930100475),"RUSSIA");
			mh10.setNember_places(10);
			mh10.setNb_voie(4);
			mh10.start();
			airports.add(mh10);
			server_airport mh11 = new server_airport(25, new position(80.96127825060933,56.02989805100475),"north russia");
			mh11.setNember_places(6);
			mh11.setNb_voie(2);
			mh11.start();
			airports.add(mh11);

			
			
			//craete networks airpoet


			
			for(String name : args){
				
				String[] data = name.split("/");
				
		

				//craete networks airpoet
				
				ArrayList<Node> nodess = new ArrayList<>();

		        Node nodeA = new Node(mh5);
		        Node nodeB = new Node(mh6);
		        Node nodeC = new Node(mh7);
		        Node nodeD = new Node(mh8);
		        Node nodeE = new Node(mh9);
		        Node nodeF = new Node(mh11);
		        Node nodeG = new Node(mh10);
		        
		        nodess.add(nodeA);
		        nodess.add(nodeB);
		        nodess.add(nodeC);
		        nodess.add(nodeD);
		        nodess.add(nodeE);
		        nodess.add(nodeF);
		        nodess.add(nodeG);
		        
		       
		        


		        nodeA.addAdjacentNode(nodeB);
		        nodeB.addAdjacentNode(nodeA);
		        nodeA.addAdjacentNode(nodeC);
		        nodeC.addAdjacentNode(nodeA);
		        
		        nodeB.addAdjacentNode(nodeD);
		        nodeD.addAdjacentNode(nodeB);
		        nodeB.addAdjacentNode(nodeE);
		        nodeE.addAdjacentNode(nodeB);
		        
		        nodeC.addAdjacentNode(nodeG);
		        nodeG.addAdjacentNode(nodeC);
		        
		        nodeE.addAdjacentNode(nodeG);
		        nodeG.addAdjacentNode(nodeE);
		        
		        nodeD.addAdjacentNode(nodeF);
		        nodeF.addAdjacentNode(nodeD);
		        
		        nodeG.addAdjacentNode(nodeF);
		        nodeF.addAdjacentNode(nodeG);
		        
		        ArrayList<Vertex<server_airport>>  Vertexs = new ArrayList<>();
		        
		        Vertex<server_airport> A = new Vertex<server_airport>(mh5);
		        Vertex<server_airport> B = new Vertex<server_airport>(mh6);
		        Vertex<server_airport> C = new Vertex<server_airport>(mh7);
		        Vertex<server_airport> D = new Vertex<server_airport>(mh8);
		        Vertex<server_airport> E = new Vertex<server_airport>(mh9);
		        Vertex<server_airport> F = new Vertex<server_airport>(mh11);
		        Vertex<server_airport> G = new Vertex<server_airport>(mh10);
		        
		        Vertexs.add(A);
		        Vertexs.add(B);
		        Vertexs.add(C);
		        Vertexs.add(D);
		        Vertexs.add(E);
		        Vertexs.add(F);
		        Vertexs.add(G);
		        
		        A.setNeighbors(new HashMap<>(Map.of(B,B.getData().getNember_places(),C,C.getData().getNember_places())));
		        B.setNeighbors(new HashMap<>(Map.of(A,A.getData().getNember_places(),D,D.getData().getNember_places(),E,E.getData().getNember_places())));
		        C.setNeighbors(new HashMap<>(Map.of(A,A.getData().getNember_places(),G,G.getData().getNember_places())));
		        D.setNeighbors(new HashMap<>(Map.of(B,B.getData().getNember_places(),F,F.getData().getNember_places())));
		        E.setNeighbors(new HashMap<>(Map.of(B,B.getData().getNember_places(),G,G.getData().getNember_places())));
		        G.setNeighbors(new HashMap<>(Map.of(E,E.getData().getNember_places(),C,C.getData().getNember_places(),F,F.getData().getNember_places())));
		        F.setNeighbors(new HashMap<>(Map.of(D,D.getData().getNember_places(),G,G.getData().getNember_places())));
		        
		        int indexsource = main1_test.return_node(nodess, data[1]);
		        int indexdest = main1_test.return_node(nodess, data[2]);
		        int flight_ID = Integer.parseInt(data[0]);
		        
		        if(indexdest!=-1 && indexsource!=-1) {
		        	
		        	
		        	

			        System.out.print("The Max Flow  from source "+Vertexs.get(indexsource).getData().getNameairport()+" to "+Vertexs.get(indexdest).getData().getNameairport()+" is : ");
			        System.out.println(new FordFulkerson<server_airport>().run(Vertexs.get(indexsource),Vertexs.get(indexdest)));
			        
			        
			        Dijkstra d1 = new Dijkstra(nodess.get(indexsource));
			        ArrayList<server_airport> a1_ecalier = d1.printPaths(List.of(nodess.get(indexdest))); 
			        
			        
					avion a1 = new avion(flight_ID,"boibng "+1+"",1+100,100); 
					a1.setCapacite(20000);
					a1.setConsomation(1);
					
					

				

					
					
					//create flights
					@SuppressWarnings("deprecation")
					flight usa_north_russia = new flight(a1,flight_ID,"usa to north russia", a1_ecalier);
					usa_north_russia .setNodes(d1.get_nodes(List.of(nodess.get(indexdest))));
					a1.setVol(usa_north_russia);
					new Thread(usa_north_russia).start();
					
					

		        	
		        	
		        	
		        }
		        
				

			
				
			}

			

 
			
			
			 

			




			new Thread(new alive_conversation_server(mh5)).start();
				 
			new Thread(new alive_conversation_server(mh6)).start();

			new Thread(new alive_conversation_server(mh7)).start();
			
			new Thread(new alive_conversation_server(mh8)).start();
			
			new Thread(new alive_conversation_server(mh9)).start();
			
			new Thread(new alive_conversation_server(mh10)).start();
			
			new Thread(new alive_conversation_server(mh11)).start();


	}

}
