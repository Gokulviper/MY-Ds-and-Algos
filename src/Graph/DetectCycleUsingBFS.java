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
    public boolean isCycle1(int V, LinkedList<Integer>[] adj ){
        boolean[]visited=new boolean[V];

        for (int i=0;i<V;i++){
            if(!visited[i]){
                if(bfs(visited,i,adj)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(boolean[] visited, int s, LinkedList<Integer>[] adj) {
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(s,-1));
    visited[s]=true;
    while (!q.isEmpty()){
        int u=q.peek().first;
        int previous=q.peek().second;
        for (int v:adj[u]){
            if (!visited[v]){
                visited[v]=true;

            }else if (previous!=v){
                return true;
            }
        }
    }
    return false;
    }


}
