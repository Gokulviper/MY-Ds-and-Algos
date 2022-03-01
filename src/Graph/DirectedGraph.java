package Graph;

import java.util.LinkedList;

public class DirectedGraph {
    int V;
    int E;
    LinkedList<Integer>[]adj;
    DirectedGraph(int nodes){
        this.V=nodes;
        this.E=0;
        adj=new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }
    public void addEdge(int u,int v){
        adj[u].add(v);
    }

    public static void main(String[] args) {

    }
}
