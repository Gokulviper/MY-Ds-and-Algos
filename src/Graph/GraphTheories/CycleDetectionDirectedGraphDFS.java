package Graph.GraphTheories;

import java.util.*;

class CycleDetectionDirectedGraphDFS {
        	
    public static void main (String[] args) {
                    	
                    	int V= 6;
                    	ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
       
                    	//Vertex - 0
                    	ArrayList<Integer> neighbors = new ArrayList<Integer>();
                    	neighbors.add(1);
                    	graph.add(neighbors);
 
                    	//Vertex - 1
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(2);
                    	neighbors.add(5);
                    	graph.add(neighbors);
 
                    	//Vertex - 2
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(3);
                    	graph.add(neighbors);
 
                    	//Vertex - 3
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(4);
                    	graph.add(neighbors);
 
                    	//Vertex - 4
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(0);
                    	neighbors.add(1);
                    	graph.add(neighbors);
 
                    	//Vertex - 5
                    	neighbors = new ArrayList<Integer>();
                    	graph.add(neighbors);
                    	
                    	if(isCyclic(V, graph))
                         System.out.println("Cycle detected");
                    	else
                         System.out.println("No cycles detected");
 
    }


	private static boolean checkCycle(int u,  ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean dfsVis[]) {
        vis[u] = true;
        dfsVis[u] = true;
        for(Integer v: adj.get(u)) {
        	if(!vis[v] ) {
                if(checkCycle(v, adj, vis, dfsVis)) {
                	return true;
            	}
        	} else if(dfsVis[v]) {
            	return true;
        	}
        }
        dfsVis[u] = false;
        return false;
    }
        	
    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[N];
        boolean dfsVis[] = new boolean[N];
       
        for(int i = 0;i<N;i++) {
        	if(!vis[i]) {
                if(checkCycle(i, adj, vis, dfsVis)) return true;
        	}
        }
        return false;
    }
}