package algo_optimisation.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import com.modul.server_airport;

public class Dijkstra {
	

    
   private  Set<Node> settledNodes;
   private  Queue<Node> unsettledNodes;
   private Node source;
    
    public Dijkstra(Node source) {
    	this.source=source;
    	this.settledNodes = new HashSet<>();
    	unsettledNodes = new PriorityQueue<>(Collections.singleton(this.source));
        this.source.setDistance(0);
        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            currentNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }
    }


    private void evaluateDistanceAndPath(Node adjacentNode, Integer edgeWeight, Node sourceNode) {
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList());
        }
    }
    


    public ArrayList<server_airport> printPaths(List<Node> nodes) {
    	ArrayList<server_airport> nodess = new ArrayList<>();
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getNameairport_from_node).map(Objects::toString)
                    .collect(Collectors.joining(" -> "));
            System.out.println("shortest path is :  ");

            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName().getNameairport(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName().getNameairport(), node.getDistance()))
            );

       
        });
        try {
        	Thread.sleep(5000);
        }
        catch(Exception e) {}
        
        for(Node n : nodes.get(0).getShortestPath() )
        {
        nodess.add(n.getName());
        }
        nodess.add(nodes.get(0).getName());
        return nodess;
    }
    
    
    public ArrayList<Node> get_nodes(List<Node> nodes) {
    	ArrayList<Node> nodess = new ArrayList<>();
        nodess.add(nodes.get(0));
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getNameairport_from_node).map(Objects::toString)
                    .collect(Collectors.joining(" -> "));       
        });
        
        for(Node n : nodes.get(0).getShortestPath() )
        {
        nodess.add(n);
        }
        return nodess;
    }
    
    
    
    


}