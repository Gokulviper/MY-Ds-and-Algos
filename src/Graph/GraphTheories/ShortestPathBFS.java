package Graph.GraphTheories;

import java.util.*;

public class ShortestPathBFS {
    /*
    make distance array so add the target at the first of queue
    you start the bfs from the target
    that easy to make distance 0 to maximize

     */


    private void shortestPath(ArrayList<ArrayList<Integer>> adj,int N,int target)
    {

        int[] distance = new int[N];
       Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<Integer> q=new LinkedList<>();
        distance[target] = 0; //target distance to reach target is zero initially make as zero
        q.add(target);

        while(!q.isEmpty())
        {
            int u = q.poll();
            for(int v:adj.get(u)){
                if(distance[u] + 1 < distance[v]){ //initially all max values and the any other shoretst find other adkacents that also updated
                    distance[v] = distance[u] + 1;
                    q.add(v);
                }
            }
        }

        for(int i = 0;i < N;i++) {
            System.out.print(distance[i] + " ");
        }
    }
}
