package Graph.GraphTheories;

import java.util.*;

class Node1 implements Comparator<Node1>
{
    private int v;
    private int weight;
    
    Node1(int _v, int _w) { v = _v; weight = _w; }
    
    Node1() {}
    
    int getValue() { return v; }
    int getWeight() { return weight; }
    
    @Override
    public int compare(Node1 node1, Node1 node2)
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}

class DijktrasAlgotithmFindingShortestPath
{
    void shortestPath1(int s, ArrayList<ArrayList<Node1>> adj, int N)
    {
        int dist[] = new int[N];
        
  Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<Node1> pq = new PriorityQueue<Node1>(N, new Node1());
        pq.add(new Node1(s, 0));
        
        while(pq.size() > 0) {
            Node1 u = pq.poll();
            
            for(Node1 v: adj.get(u.getValue())) {
                if(dist[u.getValue()] + v.getWeight() < dist[v.getValue()]) {
                    dist[v.getValue()] = dist[u.getValue()] + v.getWeight();
                    pq.add(new Node1(v.getValue(), dist[v.getValue()]));
                }
            }
        }
        System.out.println("The distances from source "+s+" are : ");
        for (int i = 0; i < N; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Node1> > adj = new ArrayList<ArrayList<Node1> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Node1>());
			
		adj.get(0).add(new Node1(1, 2));
		adj.get(1).add(new Node1(0, 2));
		
		adj.get(1).add(new Node1(2, 4));
		adj.get(2).add(new Node1(1, 4));
		
		adj.get(0).add(new Node1(3, 1));
		adj.get(3).add(new Node1(0, 1));
		
		adj.get(3).add(new Node1(2, 3));
		adj.get(2).add(new Node1(3, 3));
		
		adj.get(1).add(new Node1(4, 5));
		adj.get(4).add(new Node1(1, 5));
		
		adj.get(2).add(new Node1(4, 1));
		adj.get(4).add(new Node1(2, 1));
		
		DijktrasAlgotithmFindingShortestPath obj = new DijktrasAlgotithmFindingShortestPath();
		obj.shortestPath1(0, adj, n);
		
    }
}