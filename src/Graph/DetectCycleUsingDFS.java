package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DetectCycleUsingDFS {
    public boolean checkForCycle(int s, int parent, boolean vis[], LinkedList<Integer>[] adj) {
        vis[s] = true;
        for(Integer i: adj[s]) {
            if(!vis[i]) {
                if(checkForCycle(i, s, vis, adj))
                    return true;
            }
            else if(i!=parent)
                return true;
        }

        return false;
    }
    // 0-based indexing Graph
    public boolean isCycle(int V, LinkedList<Integer>[] adj)
    {
        boolean vis[] = new boolean[V];

        for(int i = 0;i<V;i++) {
            if(!vis[i]) {
                if(checkForCycle(i, -1, vis, adj))
                    return true;
            }
        }

        return false;
    }
}
