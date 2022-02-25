package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Adj {
    int V;
    int E;
    LinkedList<Integer>[]adj;

    Adj(int nodes){
        this.V=nodes;
        this.E=0;
        this.adj=new LinkedList[nodes];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<V;i++){
            sb.append(i+" ");
            for (int u : adj[i]){
                sb.append(u+" ");
            }
            sb.append("\n");
        }
      return   sb.toString();
    }
    public void bfs(int s){
        Queue<Integer>q=new LinkedList<>();
        boolean[] visited=new boolean[V];
        q.add(s);
        visited[s]=true;
        while (!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");

            for(int v:adj[u]){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        Adj a=new Adj(6);
        a.addEdge(0,1);
        a.addEdge(0,2);
        a.addEdge(1,3);
        a.addEdge(2,3);
        a.addEdge(3,4);
        a.addEdge(4,5);
      a.bfs(0);
    }
    }

