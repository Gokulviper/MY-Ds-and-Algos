package Graph.GraphTheories;

import java.util.*;


public class TopoLogicalSortBFS {
        public static void main(String args[]) {

            ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

            // adding new arraylists to 'adj' to add neighbour nodes
            for (int i = 0; i < 6; i++) {
                adj.add(new ArrayList < > ());
            }


            adj.get(5).add(2);
            adj.get(5).add(0);
            adj.get(4).add(0);
            adj.get(4).add(1);
            adj.get(3).add(1);
            adj.get(2).add(3);
isCyclic(6,adj);



        }

    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];

        //finding indegree
        for(int i = 0;i<N;i++) {
            for(Integer v: adj.get(i)) {
                indegree[v]++;
            }
        }


        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<N;i++) {
            //adding nodes to queue with indegree = 0
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0; //the counter is find the cycle in graph
        int ind=0;

        while(!q.isEmpty()) {
            Integer u = q.poll();
            topo[ind++] = u;
            cnt++;
            //getting neighbour nodes of popped u and decreasing  their
          //  indegree by1
            for(Integer v: adj.get(u)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        //printing topological ordering of nodes
        for (int i=0;i< topo.length;i++){
            System.out.print(topo[i]+" ");
        }
        if(cnt == N) return false;//the count== n so the all elements are filled
        //but is not return true graph has cycle
        return true;
    }
    }