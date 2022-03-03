package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DetectCycleUsingDFS {
    public boolean checkForCycle(int u, int previous, boolean vis[], LinkedList<Integer>[] adj) {
        vis[u] = true;
        for(Integer v: adj[u]) {
            if(!vis[v]) {
                if(checkForCycle(v, u, vis, adj))
                    return true;
            }
            else if(v!=previous)
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
