package Graph.GraphTheories;

import java.util.*;
class Node3 implements Comparator<Node3>
{
	private int v;
	private int weight;

	Node3(int _v, int _w) { v = _v; weight = _w; }

	Node3() {}

	int getValue() { return v; }
	int getWeight() { return weight; }

	@Override
	public int compare(Node3 node1, Node3 node2)
	{
		if (node1.weight < node2.weight)
			return -1;
		if (node1.weight > node2.weight)
			return 1;
		return 0;
	}
}
class PrimsAlgoMinimumSpanningTree{
		void prim1sAlg1o(ArrayList<ArrayList<Node3>> adj, int N)
		{
			int[]key=new int[N];
			int[] parent=new int[N];
			boolean[]mst=new boolean[N];
			PriorityQueue<Node3> pq=new PriorityQueue<>(N,new Node3());

			Arrays.fill(key,Integer.MAX_VALUE);
			key[0]=0;
			parent[0]=-1;
			pq.add(new Node3(key[0],0));
			while (!pq.isEmpty()){
				int u=pq.peek().getValue();
				mst[u]=true;
				for (Node3 v:adj.get(u)){
					if(!mst[v.getValue()]&&key[v.getValue()]>v.getWeight()){
						key[v.getValue()]=v.getWeight();
						parent[v.getValue()]=u;
					}
				}
			}


		}

	void primsAlg1o(ArrayList<ArrayList<Node3>> adj, int N)
	{
		int[]key=new int[N];
		int []parent=new int[N];
		boolean[]mst=new boolean[N];
		PriorityQueue<Node3> pq=new PriorityQueue<>(N,new Node3());
		Arrays.fill(key,Integer.MAX_VALUE);
		key[0]=0;
		parent[0]=-1;
		pq.add(new Node3(key[0],0));
		while (!pq.isEmpty()){
			int u=pq.peek().getValue();
			mst[u]=true;
			for (Node3 v:adj.get(u)){
				if (!mst[v.getValue()]&&v.getWeight()<key[v.getValue()]){
					parent[v.getValue()]=u;
					key[v.getValue()]=v.getWeight();
					pq.add(new Node3(v.getValue(),key[v.getValue()]));
				}
			}
		}

	}
    void primsAlgo(ArrayList<ArrayList<Node3>> adj, int N)
    {
        int key[] = new int[N];//this stores the edge weights get the minimum edge weight
        int parent[] = new int[N]; //this store the actual node
        boolean mst[] = new boolean[N];
       Arrays.fill(key,Integer.MAX_VALUE);
        PriorityQueue<Node3> pq = new PriorityQueue(N, new Node3());
        key[0] = 0;
        parent[0] = -1; 
        pq.add(new Node3(key[0], 0));
        while(!pq.isEmpty()) {
        	int u = pq.poll().getValue();
        	mst[u] = true;
        
        	for(Node3 v: adj.get(u)) {
  if(!mst[v.getValue()] && v.getWeight() < key[v.getValue()]) {//check the mst is not visited
  	// and already the weigth in the key array lesser
    	parent[v.getValue()] = u;//change the parent node
        			key[v.getValue()] = v.getWeight();//and change the weight
        			pq.add(new Node3(v.getValue(), key[v.getValue()]));
        		}
        	}
        }
        for(int i = 1;i<N;i++) {
        	System.out.println(parent[i] + " - " + i); 
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Node3> > adj = new ArrayList<ArrayList<Node3> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Node3>());
			
		adj.get(0).add(new Node3(1, 2));
		adj.get(1).add(new Node3(0, 2));
		
		adj.get(1).add(new Node3(2, 3));
		adj.get(2).add(new Node3(1, 3));
		
		adj.get(0).add(new Node3(3, 6));
		adj.get(3).add(new Node3(0, 6));
		
		adj.get(1).add(new Node3(3, 8));
		adj.get(3).add(new Node3(1, 8));
		
		adj.get(1).add(new Node3(4, 5));
		adj.get(4).add(new Node3(1, 5));
		
		adj.get(2).add(new Node3(4, 7));
		adj.get(4).add(new Node3(2, 7));
		
		PrimsAlgoMinimumSpanningTree obj = new PrimsAlgoMinimumSpanningTree();
		obj.primsAlgo(adj, n); 
		
    }
}