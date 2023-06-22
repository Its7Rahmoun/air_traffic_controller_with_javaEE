package algo_optimisation.dijkstra;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;



import com.modul.position;
import com.modul.server_airport;


public class Node implements Comparable<Node> {
	
    private static final double EARTH_RADIUS = 6371; // in kilometers
    private  server_airport name;
    private Integer distance = Integer.MAX_VALUE;
    private List<Node> shortestPath = new LinkedList<>();
    private Map<Node, Integer> adjacentNodes = new HashMap<>();
  //  PythonInterpreter pythonInterpreter = new PythonInterpreter();

    
    

    public Node(server_airport name) {
		super();
		this.name = name;
	}

	public server_airport getName() {
		return name;
	}
	public String getNameairport_from_node() {
		return name.getNameairport();
	}

	public void setName(server_airport name) {
		this.name = name;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return EARTH_RADIUS * c;
    }

	public void addAdjacentNode(Node node)  {
		position A1 = this.getName().getPosition();
		position B1 = node.getName().getPosition();	
        adjacentNodes.put(node, (int)(distance(A1.getLatitude(), A1.getLangitude(), B1.getLatitude(), B1.getLangitude())));
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance, node.getDistance());
    }

}
