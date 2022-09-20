package Graph.Problems.unionfind;


class   ReduententConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;

        }

        for(int[] edge : edges){
            if(union(edge[0], edge[1], parent, rank)){
                return edge;

            }
        }
        return new int[]{0,0};
    }

    private int findPar(int node, int[] parent){
        if(node == parent[node])
            return node;

        return parent[node] = findPar(parent[node], parent);
    }

    private boolean union(int u, int v, int[] parent, int[] rank){
        u = findPar(u, parent);
        v = findPar(v, parent);

        if(u == v)
            return true;

        if(rank[u] < rank[v]){
            parent[u] = v;
            rank[v]++;
        } else {
            parent[v] = u;
            rank[u]++;
        }
        return false;
    }
}
