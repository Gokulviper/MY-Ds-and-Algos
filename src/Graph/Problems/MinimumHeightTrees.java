package Graph.Problems;

import java.util.*;

class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if ( n==1 ) {
            list.add(0);
            return list;
        }
        for ( int i=0; i<n; i++ ) {
            adj.add(new ArrayList<>());
        }
        for ( int t[]: edges ) {
            int x = t[0];
            int y = t[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
            inDegree[x]++;
            inDegree[y]++;
        }
        for ( int i=0; i<n; i++ ) {
            if ( inDegree[i]==1 ) {
                queue.offer(i);
            }
        }
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            list.clear();
            while ( size-->0 ) {
                int x = queue.poll();
                list.add(x);
                for ( int j: adj.get(x) ) {
                    inDegree[j]--;
                    if ( inDegree[j]==1 ) {
                        queue.offer(j);
                    }
                }
            }
        }
        return list;
    }
        }
