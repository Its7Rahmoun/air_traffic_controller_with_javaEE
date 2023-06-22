package algo_optimisation.max_flow;



import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {

    private final T data;

    private boolean visited;


    private Map<Vertex<T>, Integer> neighbors = new HashMap<>();


	public Vertex(T data, boolean visited, Map<Vertex<T>, Integer> neighbors) {
		super();
		this.data = data;
		this.visited = visited;
		this.neighbors = neighbors;
	}
	
	public Vertex(T data) {
		super();
		this.data = data;
	}


	public boolean isVisited() {
		return visited;
	}


	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	public Map<Vertex<T>, Integer> getNeighbors() {
		return neighbors;
	}


	public void setNeighbors(Map<Vertex<T>, Integer> neighbors) {
		this.neighbors = neighbors;
	}


	public T getData() {
		return data;
	}
    
    

}