package Graph.GraphTheories;

import java.util.*;

class Node
{
	private int u;
    private int v;
    private int weight;
    
    Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}
 
//dectect a negative cycle in directed graph
class BelmanFordAlgo
{
    void bellmanFord(ArrayList<Node> adj, int N, int src)
    {
        int dist[] = new int[N];
     Arrays.fill(dist,-1);

        dist[src] = 0;
//we do the checking for n-1 times
    	for(int i = 1;i<=N-1;i++) {
    		for(Node v : adj) {
    			if(dist[v.getU()] + v.getWeight() < dist[v.getV()]) {
    				dist[v.getV()] = dist[v.getU()] + v.getWeight();
    			}
    		}
    	}

    	int flag = 0;
    	for(Node v: adj) {
    		if(dist[v.getU()] + v.getWeight() < dist[v.getV()]) {//if there is need to any changes that is negative cycle
    			//they already in the correct weights that need to be changed that reason is negative cycle
    			flag = 1;
    			System.out.println("Negative Cycle"); 
    			break;
    		}
    	}
//there is no flag its no negative cyccle
    	if(flag == 0) {
    		for(int i = 0;i<N;i++) {
    			System.out.print(  dist[i]+" "); 
    		}
    	}
    }
    public static void main(String args[])
    {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

	
		BelmanFordAlgo obj = new BelmanFordAlgo();
		obj.bellmanFord(adj, n, 0);
		
    }
}