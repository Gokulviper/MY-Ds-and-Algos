package Graph.Representation;

import java.util.*;

class BFS {


        public static ArrayList< Integer > bfsOfGraph(int V, ArrayList < ArrayList < Integer >> adj) {

        ArrayList < Integer > bfs = new ArrayList < > ();
        boolean vis[] = new boolean[V];
        Queue < Integer > q = new LinkedList < > ();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer u = q.poll();
            bfs.add(u);
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer v: adj.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return bfs;
    }
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);


        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        System.out.println(ans);



    }
}