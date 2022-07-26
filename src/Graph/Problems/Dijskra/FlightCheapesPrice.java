package Graph.Problems.Dijskra;

import java.util.*;
class Node{
    int start;
    int cost;
    int stops;
    Node(int start,int cost,int stops){
        this.start=start;
        this.cost=cost;
        this.stops=stops;
    }
}
class pair{
    int to;
    int price;
    pair(int to,int price){
        this.to=to;
        this.price=price;
    }
    int getPrice(){
        return this.price;
    }
    int getTo(){
        return this.to;
    }
}
class FlightCheapesPrice {
    public int findCheape1stPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        //Step 1:
        for(int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Map<Integer, Integer> visited = new HashMap<>(); // This is extra step to avoid TLE

        // Step 2:
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
        queue.add(new int[]{src, 0, k});
        // Step 3:
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curNode = cur[0];
            int curPrice = cur[1];
            int remainingStop = cur[2];

            if(curNode == dst) {
                return curPrice;
            }
          visited.put(curNode, remainingStop);   // To avoid TLE
  for(int[] temp : map.getOrDefault(curNode, new ArrayList<>())) {
            if(!visited.containsKey(temp[0]) || remainingStop > visited.get(temp[0]))  // This condition is to avoid TLE otherwise we add in PQ
                    {
               queue.add(new int[]{temp[0], temp[1]+curPrice, remainingStop-1});
                    }
                }
            }

        return -1;
    }
    List<List<pair>> build(int[][]a,int n){
        List<List<pair>> adj=new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            adj.get(a[i][0]).add(new pair(a[i][1],a[i][2]));
        }
        return adj;
    }




    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        //Step 1:
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Map<Integer, Integer> visited = new HashMap<>(); // This is extra step to avoid TLE

        // Step 2:
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{src, 0, k});


        // Step 3:
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curNode = cur[0];
            int curPrice = cur[1];
            int remainingStop = cur[2];

            if (curNode == dst) {
                return curPrice;
            }

            visited.put(curNode, remainingStop);   // To avoid TLE

            if (remainingStop >= 0) {
                for (int[] temp : map.getOrDefault(curNode, new ArrayList<>())) {
                    if (!visited.containsKey(temp[0]) || remainingStop > visited.get(temp[0]))  // This condition is to avoid TLE otherwise we add in PQ
                    {
                        queue.add(new int[]{temp[0], temp[1] + curPrice, remainingStop - 1});
                    }
                }
            }
        }
        return -1;
    }
}