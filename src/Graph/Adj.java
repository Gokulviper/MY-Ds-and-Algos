package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Adj {
    private int V;
    private int E;
    private LinkedList<Integer> []adj;

    Adj(int Vertices){
        this.V=Vertices;
        this.E=0;
      this.  adj=new LinkedList[Vertices];
      for (int v=0;v<V;v++){
          adj[v]=new LinkedList<>();
      }

    }
    public void addEdge(int u,int v){
        adj[v].add(u);
        adj[u].add(v);
        E++;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        System.out.println(V+" vertcies "+E+" edges");
        for(int v=0;v<V;v++){
            sb.append(v+" ");
            for (int w:adj[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void bfs(int s){
        boolean[] visited=new boolean[V];
        Queue<Integer>q=new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while (!q.isEmpty()){
            int node=q.poll();
            System.out.println(node+" ");

            for (int v:adj[node]){
                if(!visited[v]){
                    q.add(v);
                    visited[v]=true;
                }
            }
        }
    }
    public void dfs(int s){

    }

    public static void main(String[] args) {
        Adj a=new Adj(5);
        a.addEdge(0,1);
        a.addEdge(0,3);
        a.addEdge(0,4);
        a.addEdge(1,4);
        a.addEdge(2,3);
       a.bfs(0);

    }
}
