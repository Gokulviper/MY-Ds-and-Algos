package Graph.Representation;

import HashIng.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Node{
    int first;
    int second;
    Node(int first,
            int second){
        this.first=first;
        this.second=second;
    }
}
public class Adj {

    int V;
    int E;
    private static ArrayList<ArrayList<Integer>> adj;

    Adj(int cap) {
        this.V = cap;
        this.E = 0;
        adj = new ArrayList<>();
        for (int i = 0; i < cap; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int u) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " ->");
            for (int u : adj.get(i)) {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Adj graph=new Adj(6);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
    //    graph.printGraph();
        

    }


}
