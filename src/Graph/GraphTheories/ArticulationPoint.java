package Graph.GraphTheories;

import java.util.ArrayList;

class ArticulationPoint
{

	private void dfs(int u, int parent, boolean vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer, int isArticulation[]) {
		vis[u] = true;
		tin[u] = low[u] = timer++;
		int child = 0; 
		for(Integer v: adj.get(u)) {
			if(v == parent) continue;

			if(!vis[v] ) {
				dfs(v, u, vis, tin, low, adj, timer, isArticulation);
				low[u] = Math.min(low[u], low[v]);

				if(low[v] >= tin[u] && parent != -1) {
					isArticulation[u] = 1;
				}
				child++; 
			} else {
				low[u] = Math.min(low[u], tin[v]);
			}
		}
		if(parent != -1 && child > 1) isArticulation[u] = 1;  //parent have a multiple child  that unique paths makes that is articukltion point
	}
    void printBridges(ArrayList<ArrayList<Integer>> adj, int n)
    {
        boolean vis[] = new boolean[n];
        int timing[] = new int[n];
        int lowTiming[] = new int[n];
        
        int isArticulation[] = new int[n];//so duplicate articulate  points may print so we maintained if its find makes as 1

        int timer = 0; 
        for(int i = 0;i<n;i++) {
        	if(!vis[i] ) {
        		dfs(i, -1, vis, timing, lowTiming, adj, timer, isArticulation);
        	}
        }
        
        for(int i = 0;i<n;i++) {
            if(isArticulation[i] == 1) System.out.println(i); 
        }
    }
	void prin1tBridges(ArrayList<ArrayList<Integer>> adj, int n)
	{
		boolean[]vis=new boolean[n];
		int[]timing=new int[n];
		int[]lowTime=new int[n];
		int[]Articulation=new int[n];
		int timer=0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]){
				dffs(i,-1,vis,timing,lowTime,adj,Articulation,timer);
			}
		}

	}

	private void dffs(int u, int parent, boolean[] vis, int[] timing, int[] lowTime, ArrayList<ArrayList<Integer>> adj, int[] articulation, int timer) {
	vis[u]=true;

	lowTime[u]=timing[u]=timer++;
	for (int v:adj.get(u)){
		if (!vis[v]){
			dffs(v,u,vis,timing,lowTime,adj,articulation,timer);
		}

	}
	}

	public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >();
		
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
			
		ArticulationPoint obj = new ArticulationPoint();
		obj.printBridges(adj, n); 
		
    }
}