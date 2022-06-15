package Graph.GraphTheories;

import java.util.*;

class TopoLogicalSortDFS {


    static void findTopoSort(int u, boolean vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[u] = true;
        for(Integer v: adj.get(u)) {
            if(!vis[v] ) {
                findTopoSort(v, vis, adj, st);
            } 
        }
        //after pushing he values in stack order gives the topo sort order
        st.push(u);
    }
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>();
        boolean vis[] = new boolean[N];
        
        for(int i = 0;i<N;i++) {
            if(!vis[i]) {
                findTopoSort(i, vis, adj, st);
            }
        }
        
        int topo[] = new int[N];
        int ind = 0; 
        while(!st.isEmpty()) {
            topo[ind++] = st.pop();
        }

        return topo; 
    }
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=6;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(arr);
        }
        
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        int res[] = topoSort(6, adj);
   
        System.out.println("Toposort of the given graph is:" );
        for (int i = 0; i < res.length; i++) {
        System.out.print(res[i]+" ");
  }
    }
}