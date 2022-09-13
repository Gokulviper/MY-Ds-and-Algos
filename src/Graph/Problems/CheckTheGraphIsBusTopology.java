package Graph.Problems;

import java.util.ArrayList;

public class CheckTheGraphIsBusTopology
{
    boolean checkIsBUs(ArrayList<ArrayList<Integer>>adj,int V,int E){
        if (V-1!=E)return false;
        if (V==1)return true;
        int[]degree=new int[V];
        for (int i = 0; i <V ; i++) {
            for(int a:adj.get(i)){
                degree[a]++;
            }
        }
        int startAndEndCounter=0,OtherCounter=0;
        for (int i = 0; i <V ; i++) {
            if (degree[i]==1)startAndEndCounter++;
            if (degree[i]==2)OtherCounter++;
            else return false;
        }
        return startAndEndCounter==2&&OtherCounter==V-2;
    }
    public static void main(String[] args) {

    }
}
