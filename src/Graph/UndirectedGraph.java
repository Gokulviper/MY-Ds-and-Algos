package Graph;

import java.util.LinkedList;

public class UndirectedGraph {
    LinkedList<Integer>[]adj;
    int v;
    int e;
    UndirectedGraph(int nodes){
        this.v=nodes;
        this.e=0;
        this.adj=new LinkedList[nodes];
        for (int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    @Override
    public String toString() {
      StringBuilder sb=new StringBuilder();
      sb.append(v+"vertices"+e+"edges");
      for (int i=0;i<v;i++){
          sb.append(i+":");
          for (int w:adj[v]){
              sb.append(w+" ");
          }
          sb.append("\n");
      }
      return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph u=new UndirectedGraph(564);
        u.addEdge(3,4);
        u.addEdge(4,6);
        u.addEdge(3,7);
        //u.addEdge(7,9);
        u.toString();
    }
}
