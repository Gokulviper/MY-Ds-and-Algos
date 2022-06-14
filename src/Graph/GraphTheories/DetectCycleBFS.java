package Graph.GraphTheories;

import java.util.*;

class DetectCycleBFS
{
    public static void main(String[] args)

    {
       
            int V = 5;
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                adj.get(0).add(1);
                adj.get(0).add(2);
                adj.get(2).add(3);
                adj.get(1).add(3);
                adj.get(2).add(4);

            FindCycle obj = new FindCycle();
            boolean ans = obj.isCycleBfs(V, adj);
            if(ans)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }


class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second; 
    }
}
class FindCycle {
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]) {
        Queue<Node> q = new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            int u = q.peek().first;
            int previous = q.peek().second;
            q.remove();

            for (Integer v : adj.get(u)) {
                if (!vis[v]) {
                    q.add(new Node(v, u));
                    vis[v] = true;
                } else if (previous != v) return true;
            }
        }

        return false;
    }

    public boolean isCycleBfs(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        for (int i = 0; i < V; i++)
            if (!vis[i])
                if (checkForCycle(adj, i, vis))
                    return true;

        return false;
    }


}