package Graph.Representation;

import java.util.*;

class DFS {


    public static void dfs(int u, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        ans.add(u);
        //marking current u as visited
        vis[u] = true;
        //getting neighbour nodes
        for (Integer v : adj.get(u)) {
            if (!vis[v]) {
                //going recursively to the end
                dfs(v, vis, adj, ans);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        //boolean array to keep track of visited vertices
        boolean[] vis = new boolean[V + 1];
        //If you are starting from node 2, then i should start from 2.
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) dfs(i, vis, adj, ans);
        }
        return ans;
    }


    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(2).add(4);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(4).add(2);
        adj.get(5).add(1);


        ArrayList<Integer> ans = dfsOfGraph(5, adj);
        System.out.println(ans);
    }
}