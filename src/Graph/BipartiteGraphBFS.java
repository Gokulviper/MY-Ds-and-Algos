package Graph;

import java.util.*;

public class BipartiteGraphBFS {

    boolean bfsCheck(LinkedList<Integer>[] adj, int s, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        color[s] = 1;
        while(!q.isEmpty()) {
            Integer u = q.poll();
            for(Integer v: adj[u]) {
                if(color[v] == -1) {
                    color[v] = 1 - color[u];   // 1  -1 = 1-(1)=0  // 1-(0)
                    q.add(v);
                }
                else if(color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean checkBipartite(LinkedList<Integer>[] adj , int n)
    {
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++) {
            if(color[i] == -1) {
                if(!bfsCheck(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean checkBipartite1(LinkedList<Integer>[] adj , int n)
    {
     int color[]=new int[n];
     Arrays.fill(color,-1);

     for (int i=0;i<n;i++){
         if(color[i]==-1){
             if(dfs(adj,i,color)){
                 return true;
             }
         }
     }
     return false;
    }

    private boolean dfs(LinkedList<Integer>[] adj, int s, int[] color) {
        Queue<Integer>q=new LinkedList<>();
        q.add(s);
        color[s]=1;
        while (!q.isEmpty()){
            int u=q.poll();
            for (int v:adj[u]){
                if(color[v]==-1){
                    color[v]=1-color[u];
                }else if(color[v]==color[u]){
                    return false;
                }
            }
        }
        return true;
    }


}
