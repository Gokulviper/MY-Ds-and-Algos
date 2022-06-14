package Graph.GraphTheories;

import java.util.ArrayList;
import java.util.Arrays;

class BipartiteGraphDFS {

    private static boolean dfsCheck(int[] color, int u, ArrayList<ArrayList<Integer>> adj) {
        for (int v:adj.get(u)){
            if (color[v]==-1){
                color[v]=1-color[u];
                if (!dfsCheck(color,v,adj))return false;
            }else if (color[v]==color[u]){
                return false;
            }
        }
        return true;
    }

    static boolean checkBipartite(ArrayList < ArrayList < Integer >> graph, int n) {
        int color[] = new int[n];

        Arrays.fill(color,-1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(color, i, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int n = 6;
        ArrayList < ArrayList < Integer >> graph = new ArrayList <ArrayList< Integer >> ();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList < Integer > ());

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        graph.get(1).add(5);
        graph.get(5).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(3).add(5);
        graph.get(5).add(3);

        if (checkBipartite(graph, n))
            System.out.println("It is a Bipartite Graph");
        else
            System.out.println("It is not a Bipartite Graph");
    }
}