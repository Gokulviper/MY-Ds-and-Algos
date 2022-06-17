package Graph.GraphTheories;

import java.util.ArrayList;

class BridgesInGraph
{

	private void dfs(int u, int parent, boolean vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer) {
		vis[u] = true;
		tin[u] = low[u] = timer++; //both are initiating the timeer same  value of length

		for(Integer v: adj.get(u)) {
			if(v == parent) continue;
			if(!vis[v]) {
				dfs(v, u, vis, tin, low, adj, timer);
				low[u] = Math.min(low[u], low[v]);//after the reach the end the recursive the change low array make that and pervious positon

				if(low[v] > tin[u]) {  //this case no way to reach the index so that is bridge
					System.out.println(v + " " +u);
				}
			} else {
				low[u] = Math.min(low[u], tin[v]); //otherwise you can go the path  using other way
			}
		}
	}



	void printBridges(ArrayList<ArrayList<Integer>> adj, int n)
    {
       boolean vis[] = new boolean[n];
        int tin[] = new int[n];
        int low[] = new int[n]; 

        int timer = 0; 
        for(int i = 0;i<n;i++) {
        	if(!vis[i] ) {
        		dfs(i, -1, vis, tin, low, adj, timer); 
        	}
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
			
		BridgesInGraph obj = new BridgesInGraph();
		obj.printBridges(adj, n); 
		
    }
}