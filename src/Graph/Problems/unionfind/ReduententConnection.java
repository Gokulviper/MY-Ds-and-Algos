package Graph.Problems.unionfind;
class unionFind{
    int[] parent;
    int[] rank;

    public unionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}

class ReduententConnection {
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        unionFind unionFind=new unionFind(MAX_EDGE_VAL+1);
        for (int[]e:edges){
            if (!unionFind.union(e[0],e[1])){
                return e;
            }
        }
        return new int[]{-1,-1};
    }
    }