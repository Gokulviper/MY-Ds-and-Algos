package Graph.Problems;

import java.util.ArrayList;
//the problem is check the course is valid finsih or not
//the graph had a cycle we do not get the ans because we dont chose the starting point
//because the depencency we use directed graph because the graph are undirected
//we do not predict which is the starting point
//use the cycle detection algorithm for khan
class courseSchdule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>>adj=createGraph(numCourses,prerequisites);
        boolean ans=isCyclic(adj.size(),adj);
        return !ans;
        
    }
    private static boolean checkCycle(int u, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean dfsVis[]) {
     //use backtracking because some points become over w need to check for next
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
     private ArrayList<ArrayList<Integer>> createGraph(int numCourses, int[][] pre) {
        //this function nothing the question
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] course : pre) {
            graph.get(course[0]).add(course[1]);
        }
        return graph;
    }
}