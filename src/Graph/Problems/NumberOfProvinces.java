package Graph.Problems;

import java.util.Arrays;

class NumberOfProvinces {
    public static void main(String[] args) {

    }
    public int findCircleNum(int[][] isConnected) {
        boolean []vis=new boolean[isConnected.length];
        int ans=0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                dfs(vis,i,isConnected);
                ans++;
            }
        }
        return ans;
    }
    void dfs(boolean[]vis,int u,int[][] adj){
        vis[u]=true;
        for(int v=0;v<adj.length;v++){
            if(!vis[v]&&adj[u][v]==1){
                dfs(vis,v,adj);
            }
        }
    }
}