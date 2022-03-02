package Graph;

import java.util.*;

public class TopologicalSort {
    static void findTopoSort(int u, boolean vis[], LinkedList<Integer>[] adj, Stack<Integer> stack) {
        vis[u] = true;
        for (Integer v : adj[u]) {
            if (!vis[v]) {
                findTopoSort(v, vis, adj, stack);
            }
        }
        stack.push(u);
    }
    static int[] topoSort(int V,LinkedList<Integer>[]  adj) {
        Stack<Integer> st = new Stack<Integer>();
        boolean vis[] = new boolean[V];

        for(int i = 0;i<V;i++) {
            if(!vis[i]) {
                findTopoSort(i, vis, adj, st);
            }
        }

        int topo[] = new int[V];
        int i = 0;
        while(!st.isEmpty()) {
            topo[i++] = st.pop();
        }
        // for(int i = 0;i<V;i++) System.out.println(topo[i] + " ");
        return topo;
    }
    static int[] topoSor1t(int V,LinkedList<Integer>[]  adj) {
        boolean[]visited=new boolean[V];
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<V;i++){
            if(!visited[i]){
                find(i,stack,adj,visited);
            }
        }
        int i=0;
        int[] ans=new int[V];
        while (!stack.isEmpty()){
           ans[i++]= stack.pop();
        }
        return ans;
    }

    private static void find(int u, Stack<Integer> stack, LinkedList<Integer>[] adj, boolean[] visited) {
        visited[u]=true;
        for (int v:adj[u]){
            if (!visited[v]){
                find(v,stack,adj,visited);
            }
        }
        stack.push(u);
    }
}
