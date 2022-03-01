package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BipartiteGraphDFS {
    boolean dfsCheck(LinkedList<Integer>[]adj, int u, int color[]) {
        for(Integer v: adj[u]) {
            if(color[v] == -1) {
                color[v] = 1 - color[u];

                if(!dfsCheck(adj, v, color))
                    return false;
            }
            else if(color[v] == color[u]) {
                return false;
            }
        }
        return true;
    }


    boolean checkBipartite(LinkedList<Integer>[]adj, int n)
    {
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++) {
            if(color[i] == -1) {
                if(!dfsCheck(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
