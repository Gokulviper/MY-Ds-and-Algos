package Graph.Problems;

import java.util.*;

class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList();

        // security check 1
        if(n <= 0) return res;

        // security check 2
        // returning the root node itself
        if(n == 1) {
            res.add(0);
            return res;
        }

        // indegree
        int[] indegree = new int[n];
        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        // for each and every node add an empty adjacency list
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        // adjacency list for every node is updated
        for(int[] e: edges) {
            indegree[e[0]]++;
            indegree[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // BFS starts
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(indegree[i] == 1) {
                queue.add(i);
            }
        }

        // There can be atmost 2 MHTs
        while(n > 2) {
            int size = queue.size();
            n -= size;

            // if we remove a leaf node, the neighbouring nodes' degrees must be decremented
            while(size --> 0) {
                int u = queue.poll();
                for(int v: adj.get(u)) {
                    indegree[v]--;
                    // the queue maintains all the nodes of indegree 1
                    if(indegree[v] == 1) {
                        queue.add(v);
                    }
                }
            }
        }

        res.addAll(queue);
        return res;
    }
        }
