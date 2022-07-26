package Graph.GraphTheories;

class DisjointUnionSets {
    int[] rank, parent;
    int n;
    // Constructor
    public DisjointUnionSets(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }
    // Creates n sets with single item in each
    void makeSet()
    {
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in
            // their own set.
            parent[i] = i;
        }
    }
    // Returns representative of x's set
    int findParent(int x)
    {
        // Finds the representative of the set
        // that x is an element of
        if (parent[x] != x) {
            // if x is not the parent of itself
            // Then x is not the representative of
            // his set,
            parent[x] = findParent(parent[x]);
 
            // so we recursively call Find on its parent
            // and move i's node directly under the
            // representative of this set
        }
 
        return parent[x];
    }
 
    // Unites the set that includes u and the set
    // that includes u
    void union(int u, int v)
    {
        // Find representatives of two sets
        int node1 = findParent(u), node2 = findParent(v);
 
        // Elements are in the same set, no need
        // to unite anything.
        if (node1 == node2)
            return;
 
        // If u's rank is less than v's rank
        if (rank[node1] < rank[node2])
 
            // Then move u under v  so that depth
            // of tree remains less
            parent[node1] = node2;
 
        // Else if v's rank is less than u's rank
        else if (rank[node2] < rank[node1])
 
            // Then move v under u so that depth of
            // tree remains less
            parent[node2] = node1;
 
        else // if ranks are the same
        {
            // Then move v under u (doesn't matter
            // which one goes where)
            parent[node2] = node1;
 
            // And increment the result tree's
            // rank by 1
            rank[node1] = rank[node1] + 1;
        }
    }
}
 
// Driver code
public class DisJoinedSetDs {
    public static void main(String[] args)
    {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointUnionSets dus =
                new DisjointUnionSets(n);
 
        // 0 is a friend of 2
        dus.union(0, 2);
 
        // 4 is a friend of 2
        dus.union(4, 2);
 
        // 3 is a friend of 1
        dus.union(3, 1);
 
        // Check if 4 is a friend of 0
        if (dus.findParent(4) == dus.findParent(0))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        // Check if 1 is a friend of 0
        if (dus.findParent(1) == dus.findParent(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}