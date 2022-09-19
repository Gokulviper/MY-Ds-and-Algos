package Graph.GraphTheories;

import java.util.*;
//this is dijskra s algo for finding sortest path in undirected graph
//make a  distance use pq for get the minimum value
//and update using the weight
class Node1
{
    private int v;
    private int weight;
    
    Node1(int v, int w) { this.v = v; this.weight = w; }
    
    Node1() {}
    
    int getValue() { return v; }
    int getWeight() { return weight; }
    

}

class DijktrasAlgotithmFindingShortestPath
{
    void short1estPath(int s, ArrayList<ArrayList<Node1>> adj, int N){
        int[]dis=new int[N];
        Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<Node1>pq=new PriorityQueue<>((a,b)->a.getWeight()-b.getWeight());
        pq.add(new Node1(s,0));
        while (!pq.isEmpty()){
            Node1 u=pq.poll();
            for (Node1 v:adj.get(u.getValue())){
                if (dis[u.getValue()]+v.getWeight()<dis[v.getValue()]){
                    dis[v.getValue()]=dis[u.getValue()]+v.getWeight();
                    pq.add(new Node1(v.getValue(),dis[v.getWeight()]));
                }
            }
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
	//	obj.shortestPath(0, adj, n);
		
    }
}