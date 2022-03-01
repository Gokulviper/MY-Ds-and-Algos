package Graph;

import java.util.*;

class DetectTheCycleInDirectedGraph {
    private boolean checkCycle(int u, LinkedList<Integer>[] adj, int vis[], int dfsVis[]) {
        vis[u] = 1;
        dfsVis[u] = 1;
        
        for(Integer v: adj[u]) {
            if(vis[v] == 0) {
                if(checkCycle(v, adj, vis, dfsVis)) {
                    return true; 
                }
            } else if(dfsVis[v] == 1) {
                return true; 
            }
        }
        dfsVis[u] = 0;
        return false; 
    }
    public boolean isCyclic(int V,LinkedList<Integer>[] adj) {
        int vis[] = new int[V];
        int dfsVis[] = new int[V];
        
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis)) return true;
            }
        }
        return false; 
    }
}