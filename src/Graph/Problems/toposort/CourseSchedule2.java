package Graph.Problems.toposort;

import java.util.*;

class CourseSchedule2 {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=build(n,prerequisites);
      int[]in=new int[n];
        for(int i=0;i<n;i++){
            for(int v:adj.get(i)){
                in[v]++;
            }
        }
        Queue<Integer> q=new LinkedList();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
     List<Integer> res=new ArrayList();
        while(!q.isEmpty()){
             int u=q.poll();
          res.add(u);
           
            for(int v:adj.get(u)){
                in[v]--;
                if(in[v]==0)q.add(v);
            }
        }
       if(res.size()<n)return new int[0];
        int[]ans=new int[n];
        int k=n-1;
        for(int i=0;i<n;i++){
            ans[k--]=res.get(i);
        }
        return ans;
        
    }
     ArrayList<ArrayList<Integer>> build(int n,int[][]pre){
          ArrayList<ArrayList<Integer>> adj=new ArrayList();
         for(int i=0;i<n;i++){
             adj.add(new ArrayList());
         }
         for(int[]c:pre){
             adj.get(c[0]).add(c[1]);
         }
         return adj;
     }
}