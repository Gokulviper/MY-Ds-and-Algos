package Graph;

import java.util.*;
//same khans algorithm
class DetectCycleDirectedBFS {
    public boolean isCyclic(int V, LinkedList<Integer>[] adj) {
        int topo[] = new int[V];
        int indegree[] = new int[V];
        for(int i = 0;i<V;i++) {
            for(Integer v: adj[i]) {
                indegree[v]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
            for(int i = 0;i<V;i++) {
                if(indegree[i] == 0) {
                q.add(i); 
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Integer u = q.poll();
            cnt++; 
            for(Integer v: adj[u]) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        if(cnt == V) return false;
        return true; 
    }
}