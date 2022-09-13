package Graph.Problems;

import java.util.ArrayList;

class IsValidPath {
public boolean validPath(int n, int[][] edges, int source, int destination){
    ArrayList<ArrayList<Integer>> adj=build(edges,n);
    boolean[]vis=new boolean[n];
   dfs(n,adj,source,destination,vis);
    return vis[destination];
}
    void dfs(int n,ArrayList<ArrayList<Integer>> adj,int s,int d,boolean[]vis){
       // if()
     vis[s]=true;
        for(int v:adj.get(s)){
            if(!vis[v]){
                dfs(n,adj,v,d,vis);
            }
        }
        return;
    }
     ArrayList<ArrayList<Integer>> build(int[][]edges,int n){
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	for(int i=0;i<n;i++) {
		graph.add(new ArrayList<>());
	}

	for(int[] edge: edges) {
		graph.get(edge[0]).add(edge[1]);
		graph.get(edge[1]).add(edge[0]);
	}

	return graph;
     }
}