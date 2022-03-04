package Graph;

import java.util.LinkedList;
import java.util.*;
//find all all conection and make the connection of all nodes as marked
//example 4 has 2 connection mark four as two conncetion
//if any connection is zero take the value that is part of topo sort
//make bfs and if the element is zero push the queue that elemnet when out that is part of topo sort

public class TopoLogicalBFS {
    public boolean isCyclic(int N, LinkedList<Integer>[]adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];
        for(int i = 0;i<N;i++) {
            for(Integer it: adj[i]) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll();
            cnt++;
           // System.out.println(node+" ");
            for(Integer v: adj[node]) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        if(cnt == N) return false;
        return true;
    }
}
