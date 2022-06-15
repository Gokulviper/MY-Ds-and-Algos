package Graph.GraphTheories;

import java.util.*;
//shortest path using directed acyclic graph
class pair
{
    private int v;
    private int weight;
    pair(int _v, int _w) {
        v = _v; weight = _w;
    }
    int getV() {
        return v;
    }
    int getWeight() {
        return weight;
    }
}

class Main
{

    void topologicalSortUtil(int node, Boolean visited[], Stack stack, ArrayList<ArrayList<pair>> adj)
    {

        visited[node] = true;
        for(pair v: adj.get(node)) {
            if(!visited[v.getV()]) {
                topologicalSortUtil(v.getV(), visited, stack, adj);
            }
        }
        stack.add(node);
    }

    void shortestPath(int s, ArrayList<ArrayList<pair>> adj, int N)
    {
        Stack stack = new Stack();
        int dist[] = new int[N];

        Boolean visited[] = new Boolean[N];
        for (int i = 0; i < N; i++)
            visited[i] = false;

        for (int i = 0; i < N; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, adj);

        for (int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (!stack.empty())
        {
            int node = (int)stack.pop();

            if (dist[node] != Integer.MAX_VALUE)
            {
                for(pair it: adj.get(node)) {
                    if(dist[node] + it.getWeight() < dist[it.getV()]) {
                        dist[it.getV()] = dist[node] + it.getWeight(); 
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
		Main obj = new Main();
		obj.shortestPath(0, adj, n); 
		
    }
}