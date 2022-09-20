package Graph.Problems.Dijskra;

import java.util.*;
class pairsss {
    int to;
    int time;
    public pairsss(int to, int time){
        this.to=to;
        this.time=time;
    }
}
class NetworkDelaytime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pairsss>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<pairsss>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new pairsss(times[i][1],times[i][2]));
        }

        int dis[]=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<pairsss> pq=new PriorityQueue<>((a, b)->a.time-b.time);
        pq.offer(new pairsss(k,0));
        while(!pq.isEmpty()){
            pairsss u=pq.poll();
            for(pairsss v:adj.get(u.to)){
                if(v.time+dis[u.to]<dis[v.to]){
                    dis[v.to]=v.time+dis[u.to];
                    pq.offer(new pairsss(v.to,dis[v.to]));
                }
            }
        }
        int max=0;
        for(int i=1;i<dis.length;i++){
            max=Math.max(dis[i],max);
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            //System.out.println(dis[i]);
        }
        return max;
    }
}