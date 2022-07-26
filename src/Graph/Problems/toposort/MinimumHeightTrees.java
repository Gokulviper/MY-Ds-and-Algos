package Graph.Problems.toposort;

import java.util.*;
//there is odd number of nodes 0 1 2 3  three is only one or 2
//
// mht is maximum so simply take reduce the longest lenghts first remove
// all 1 indegree node so threr is process simply woring find last two nodes or
// 1 nodes is mht  topo sort bfs
class MinimumHeightTrees {
    public static void main(String[] args) {
        String s="*** rithvik ***";
        for (int i = 0; i <50 ; i++) {
         int ch= s.charAt(3);
            System.out.println((char)ch+32);
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans=new ArrayList();
        if(n<=0)return ans;
        if(n==1){
            ans.add(0);
            return ans;
        }
        List<List<Integer>> adj=build(n,edges);
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int v:adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.add(i);
            }
        }
        while(n>2){
            int size=q.size();
            n-=size;
            while(size-->0){
                int u=q.poll();
                for(int v:adj.get(u)){
                    indegree[v]--;
                    if(indegree[v]==1){
                        q.add(v);
                    }
                }
            }
        }

        ans.addAll(q);
        return ans;
    }
    List<List<Integer>> build(int n,int[][]edges){
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int[]e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
}