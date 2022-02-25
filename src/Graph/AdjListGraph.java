package Graph;

import java.util.*;

public class AdjListGraph {

    private LinkedList<Integer>[] adj;
    private int V; // number of vertices
    private int E; // number of edges

    public AdjListGraph(int nodes) {
        this.V = nodes;
        this.E = 0;   //initialy edges is 0 wd can add every edges in manual adding edges
        this.adj = new LinkedList[nodes]; //craeted inner linked list arrays
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void bfs(int s) {
        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : adj[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while(!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");

                for(int v : adj[u]) {
                    if(!visited[v]) {

                        stack.push(v);
                    }
                }
            }
        }
    }

    public void dfs(){
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; v++){
            if(!visited[v]){
                dfs(v, visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int w : adj[v]){
            if(!visited[w]){
                dfs(w, visited);
            }
        }
    }

    public static void main(String[] args) {
        AdjListGraph g = new AdjListGraph(5);
        DetectCycleUsingBFS d=new DetectCycleUsingBFS();
        DetectCycleUsingDFS dd=new DetectCycleUsingDFS();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
       g.dfs(0);
        System.out.println(dd.isCycle(g.V, g.adj));

        // 4
     //   System.out.println(g);
      //  g.toString();


    }
}