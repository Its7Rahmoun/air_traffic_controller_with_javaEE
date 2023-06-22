package algo_optimisation.max_flow;

import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Vertex<String> S = new Vertex<String>("S");
        Vertex<String> A = new Vertex<String>("A");
        Vertex<String> B = new Vertex<String>("B");
        Vertex<String> C = new Vertex<String>("C");
        Vertex<String> D = new Vertex<String>("D");
        Vertex<String> T = new Vertex<String>("T");

        S.setNeighbors(new HashMap<>(Map.of(A, 15, B, 12)));
        A.setNeighbors(new HashMap<>(Map.of(S,10,B, 10, C, 12, D, 1)));
        B.setNeighbors(new HashMap<>(Map.of(S,7,D, 14)));
        C.setNeighbors(new HashMap<>(Map.of(A,5,T, 25)));
        D.setNeighbors(new HashMap<>(Map.of(A,9,B,4,C, 10, T, 4)));
        T.setNeighbors(new HashMap<>(Map.of(C,10,D,8)));

        System.out.print("The Max Flow is: ");
        System.out.println(new FordFulkerson<String>().run(S, T));

        S.setNeighbors(new HashMap<>(Map.of(A, 15, B, 12)));
        A.setNeighbors(new HashMap<>(Map.of(S,10,B, 10, C, 12, D, 1)));
        B.setNeighbors(new HashMap<>(Map.of(S,7,D, 14)));
        C.setNeighbors(new HashMap<>(Map.of(A,5,T, 25)));
        D.setNeighbors(new HashMap<>(Map.of(A,9,B,4,C, 10, T, 4)));
        T.setNeighbors(new HashMap<>(Map.of(C,10,D,8)));
        
        System.out.print("The Max Flow is: ");
        System.out.println(new FordFulkerson<String>().run(T, S));


	}

}
