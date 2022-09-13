package Graph.Problems;

import java.util.ArrayList;

public class CheckTheGraphIsStarTopology {
    boolean checkIsStar(ArrayList<ArrayList<Integer>>adj,int V,int E){
        if (V-1!=E)return false;
        int[]degree=new int[V];
        for (int i = 0; i <V ; i++) {
            for(int a :adj.get(i)){
                degree[a]++;
            }
        }
        boolean isValuedOut=false;
        int isvalCount=0;
        int oneDegree=0;
        for (int i = 0; i <V ; i++) {
            if (degree[i]==1)oneDegree++;
            else if (degree[i]==V-1){
                isValuedOut=true;
            isvalCount++;
            }
        }
        return isValuedOut&&oneDegree+isvalCount==V;
    }
    public static void main(String[] args) {

    }
}
