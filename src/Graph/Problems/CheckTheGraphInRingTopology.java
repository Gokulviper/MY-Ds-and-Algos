package Graph.Problems;

import java.util.ArrayList;

/*
A graph of V vertices represents a Ring topology
if it satisfies the following three conditions:

1)Number of vertices >= 3.
2)All vertices should have degree 2.
3)No of edges = No of Vertices.
 */
public class CheckTheGraphInRingTopology {
    boolean checkIfRink(ArrayList<ArrayList<Integer>>adj,int v,int e){
        if (v!=e)return false;
        if (v<=2)return false;
        int degree[]=new int[v];
        for (int i = 0; i <v ; i++) {
            for (int k:adj.get(i)){
                degree[k]++;
            }
        }
        int countDegree=0;
        for (int i = 0; i <v ; i++) {
           if (degree[i]==2)countDegree++;
        }
        return countDegree==v;
    }
    public static void main(String[] args) {

    }
}
