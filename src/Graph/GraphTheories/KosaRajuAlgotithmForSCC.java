package Graph.GraphTheories;

import java.util.*;

class KosaRajuAlgotithmForSCC
{
	/*
	1)first find the topo sort
	2)use the stack get from the topo sort
	//create new graph for transpose graph
	3)make a transpose graph-because the we change directions so the strong components dosent go out
	4)again make a dfs call for the ordering in the stack is reversely called the dfs
	 */
	private void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
		vis[node] = true;
		for(Integer it : adj.get(node)) {
			if(!vis[it] ) {
				dfs(it, st, adj, vis); 
			}
		}

		st.push(node); 
	}

	private void revDfs(int u, ArrayList<ArrayList<Integer>> transpose, boolean vis[]) {
		vis[u] = true;
		System.out.print(u + " ");
		for(Integer v : transpose.get(u)) {
			if(!vis[v] ) {
				revDfs(v, transpose, vis);
			}
		}
	}

    void kosaRaju(ArrayList<ArrayList<Integer>> adj, int n)
    {
        boolean vis[] = new boolean[n];
        Stack<Integer> st = new Stack<Integer>(); 
        for(int i = 0;i<n;i++) {
        	if(!vis[i]) {
        		dfs(i, st, adj, vis); 
        	}
        }

        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			transpose.add(new ArrayList<Integer>());
  Arrays.fill(vis,false);
		for(int i = 0;i<n;i++) {

			for(Integer it: adj.get(i)) {
				transpose.get(it).add(i); 
			}
		}

		while(!st.isEmpty()) {
			int node = st.peek(); 
			st.pop(); 
			if(!vis[node] ) {
				System.out.print("SCC: "); 
				revDfs(node, transpose, vis);
				System.out.println(); 
			}
		}

    }


	public static void main(String args[])
    {
        int n = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(1).add(3);
		adj.get(2).add(1);
		adj.get(3).add(2);
		adj.get(3).add(5);
		adj.get(4).add(6);
		adj.get(5).add(4);
		adj.get(6).add(5);

			
		KosaRajuAlgotithmForSCC obj = new KosaRajuAlgotithmForSCC();
		obj.kosaRaju(adj, n); 
		
    }
}