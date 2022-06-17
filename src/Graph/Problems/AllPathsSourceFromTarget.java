package Graph.Problems;

import java.util.*;

class AllPathsSourceFromTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     List<List<Integer>> ans=new ArrayList();
        List<Integer> path=new ArrayList();
        dfs(graph,ans,path,0);
        return ans;
    }
    private void dfs(int[][]graph,  List<List<Integer>> ans,  List<Integer> path,int u){
        path.add(u);
        if(u==graph.length-1){
            ans.add(new ArrayList(path));
        }
        for(int v:graph[u]){
            dfs(graph,ans,path,v);
        }
        path.remove(path.size()-1);
    }
}