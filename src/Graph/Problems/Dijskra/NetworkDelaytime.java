package Graph.Problems.Dijskra;

import java.util.*;
class Pair{
    int to;
    int time;
    public Pair(int to,int time){
        this.to=to;
        this.time=time;
    }
}
class NetworkDelaytime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        int t[]=new int[n+1];
        Arrays.fill(t,Integer.MAX_VALUE);
        t[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((p1,p2)->Integer.compare(p1.time,p2.time));
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            for(Pair x:adj.get(curr.to)){
                if(x.time+t[curr.to]<t[x.to]){
                    t[x.to]=x.time+t[curr.to];
                    pq.offer(new Pair(x.to,t[x.to]));
                }
            }
        }
        int max=0;
        for(int i=1;i<t.length;i++){
            max=Math.max(t[i],max);
            if(t[i]==Integer.MAX_VALUE){
                return -1;
            }
            //System.out.println(t[i]);
        }
        return max;
    }
}