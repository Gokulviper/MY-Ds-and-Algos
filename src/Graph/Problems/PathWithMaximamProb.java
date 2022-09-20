package Graph.Problems;

import java.util.*;
class pair{
    int key;
    double value;

    public pair(int key,double value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){return key;}
    public double getValue(){return value;}
}
class PathWithMaximamProb {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],succProb[i]));
        }

        double prob[] = new double[n];
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            if(b.getValue()>a.getValue()){
                return 1;
            }
            return -1;

        });
        Arrays.fill(prob,0);
        prob[start]=1;
        pq.offer(new pair(start,1));

        while(!pq.isEmpty()){
            int u = pq.poll().getKey();

            for(pair p :adj.get(u)){
                int v = p.getKey();
                double cost = p.getValue();

                if(prob[v]==0){
                    prob[v] = prob[u]*cost;
                    pq.offer(new pair(v,prob[v]));
                }else{
                    if(prob[u]*cost>prob[v]){
                        prob[v] = prob[u]*cost;
                        pq.offer(new pair(v,prob[v]));
                    }
                }
            }
        }

        return prob[end];
    }
}