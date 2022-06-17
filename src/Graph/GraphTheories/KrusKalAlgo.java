package Graph.GraphTheories;


import java.util.*;

class Node6
{
	private int u;
	private int v;
	private int weight;

	Node6(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }

	Node6() {}

	int getV() { return v; }
	int getU() { return u; }
	int getWeight() { return weight; }

}

class SortComparator implements Comparator<Node6> {
	@Override
	public int compare(Node6 node1, Node6 node2)
	{
		if (node1.getWeight() < node2.getWeight())
			return -1;
		if (node1.getWeight() > node2.getWeight())
			return 1;
		return 0;


	}
}
class KrusKalAlgo
{
	private int findPar(int u, int parent[]) {
		if(u==parent[u]) return u;
		return parent[u] = findPar(parent[u], parent); 
	}
	private void union(int u, int v, int parent[], int rank[]) {
		u = findPar(u, parent); 
		v = findPar(v, parent);
		if(rank[u] < rank[v]) {
        	parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
        	parent[v] = u; 
        }
        else {
        	parent[v] = u;
        	rank[u]++; 
        }
	}
    void KruskalAlgo(ArrayList<Node6> adj, int N)
    {
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[N]; 
        int rank[] = new int[N];

        for(int i = 0;i<N;i++) {
        	parent[i] = i;
        }

        int costMst = 0;
        ArrayList<Node6> mst = new ArrayList<Node6>();
        for(Node6 it: adj) {
        	if(findPar(it.getU(), parent) != findPar(it.getV(), parent)) {
        		costMst += it.getWeight(); 
        		mst.add(it); 
        		union(it.getU(), it.getV(), parent, rank); 
        	}
        } 
        System.out.println(costMst);
        for(Node6 it: mst) {
        	System.out.println(it.getU() + " - " +it.getV()); 
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<Node6> adj = new ArrayList<Node6>();
		
			
		adj.add(new Node6(0, 1, 2));
		adj.add(new Node6(0, 3, 6));
		adj.add(new Node6(1, 3, 8));
		adj.add(new Node6(1, 2, 3));
		adj.add(new Node6(1, 4, 5));
		adj.add(new Node6(2, 4, 7));

	
		KrusKalAlgo obj = new KrusKalAlgo();
		obj.KruskalAlgo(adj, n);
		
    }
}