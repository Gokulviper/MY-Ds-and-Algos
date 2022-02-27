package Graph;

import java.util.*;

class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class DetectCycleUsingBFS {

    static boolean checkForCycle(LinkedList<Integer>[] adj, int s, boolean vis[])
    {
        Queue<Node> q =  new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] =true;

        while(!q.isEmpty())
        {
            int u = q.peek().first;
            int previous = q.peek().second;
            q.remove();

            for(Integer v: adj[u])
            {
                if(!vis[v])
                {
                    q.add(new Node(v, u));
                    vis[v] = true;
                }

                else if(previous != v) return true;
            }
        }

        return false;
    }
    public boolean isCycle(int V, LinkedList<Integer>[] adj )
    {
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if (!vis[i]) {
                if (checkForCycle(adj, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }



}