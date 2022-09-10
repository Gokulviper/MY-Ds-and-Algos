package Graph.Representation;

import java.util.*;

public class AdjListGraph {

    private ArrayList<ArrayList<Integer>> adj;
    private int V; // number of vertices
    private int E; // number of edges

    public AdjListGraph(int nodes) {
        this.V = nodes;
        this.E = 0;   //Initialy edges is 0 wd can add every edges in manual adding edges
        this.adj = new ArrayList<>(); //craeted inner linked list arrays
      for (int i=0;i<V;i++){
          adj.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
        E++;
    }

  public void print(){
      for (int i = 0; i < V; i++) {
          for (int j = 0; j < adj.get(i).size(); j++) {
              System.out.print(adj.get(i).get(j)+" ");
          }
          System.out.println();
      }

  }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : adj.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }}
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

                for(int v : adj.get(u)) {
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

    private void dfs(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        AdjListGraph g = new AdjListGraph(7);
      //  DetectCycleUsingBFS d=new DetectCycleUsingBFS();
     //   DetectCycleUsingDFS dd=new DetectCycleUsingDFS();
      //  BipartiteGraphBFS b=new BipartiteGraphBFS();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(1, 6);
      //  System.out.println(g.toString());

          g.print();


    }
}