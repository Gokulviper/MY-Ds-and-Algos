package Graph.GraphTheories;

import java.util.*;
//shortest path using directed acyclic graph
//we already create graph is duel node the node long how is from source
//to maintain the using the current distance + graph.getweight
class pair
{
    private int v;
    private int weight;
    pair(int _v, int _w) {
        v = _v; weight = _w;
    }
    int getValue() {
        return v;
    }
    int getWeight() {
        return weight;
    }
}

class ShotestPathDAGGraph
{

  static   void topologicalSortUtil(int u, boolean visited[], Stack stack, ArrayList<ArrayList<pair>> adj)
    {

        visited[u] = true;
        for(pair v: adj.get(u)) {
            if(!visited[v.getValue()]) {
                topologicalSortUtil(v.getValue(), visited, stack, adj);
            }
        }
        stack.push(u);
    }

  static   void shortestPath(int target, ArrayList<ArrayList<pair>> adj, int N)
    {
        Stack stack = new Stack();
        int dist[] = new int[N];
Arrays.fill(dist,Integer.MAX_VALUE);
        boolean visited[] = new boolean[N];
        for (int i = 0; i < N; i++)
        {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }
        dist[target] = 0;
        while (!stack.empty())
        {
            int u = (int)stack.pop();
            if (dist[u] != Integer.MAX_VALUE)
            {
                for(pair v: adj.get(u)) {
                    if(dist[u] + v.getWeight() < dist[v.getValue()]) {
                        dist[v.getValue()] = dist[u] + v.getWeight();
                    }
                }
            }
        }
        for (int i = 0; i < N; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 6;
        ArrayList<ArrayList<pair> > adj = new ArrayList<ArrayList<pair> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<pair>());
			
		adj.get(0).add(new pair(1, 2));
		adj.get(0).add(new pair(4, 1));
		adj.get(1).add(new pair(2, 3));
		adj.get(2).add(new pair(3, 6));
		adj.get(4).add(new pair(2, 2));
		adj.get(4).add(new pair(5, 4));
		adj.get(5).add(new pair(3, 1));
		DijktrasAlgotithmFindingShortestPath obj = new DijktrasAlgotithmFindingShortestPath();
		shortestPath(0, adj, n);
		
    }
}