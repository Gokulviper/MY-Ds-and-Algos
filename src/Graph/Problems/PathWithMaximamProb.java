package Graph.Problems;

import java.util.*;
class pair{
    int key;double value;
    pair(int k,double v){
        key=k;
        value=v;
    }
}
class PathWithMaximamProb {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<pair>> adj=new ArrayList();
         for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new pair(edges[i][1],succProb[i]));
              adj.get(edges[i][1]).add(new pair(edges[i][0],succProb[i]));
        }
    double prob[]=new double[n];
        Arrays.fill(prob,0);
  PriorityQueue<pair>pq=new PriorityQueue<>((a,b)-> (int) (b.value-a.value));
  pq.add(new pair(start,1));
        prob[0]=1;
while(!pq.isEmpty()){
    pair p=pq.poll();
    int u=p.key;
   // double cost=p.value;
    for(pair v:adj.get(u)){
        if(prob[v.key]==1){
            prob[v.key]=prob[u]*v.value;
            pq.add(new pair(v.key,prob[v.key]));
        }else{
            if(prob[v.key]<prob[u]*v.value){
                prob[v.key]=prob[u]*v.value;
                pq.add(new pair(v.key,prob[v.key]));
            }
        }
    }
}
        return prob[end];
    }
}