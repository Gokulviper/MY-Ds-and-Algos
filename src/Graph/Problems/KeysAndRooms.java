package Graph.Problems;

import java.util.*;

class KeysAndRooms {
    public static void main(String[] args) {
//[[1],[2],[3],[]]
        List<List<Integer>>list=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(0).add(3);
        list.get(1).add(3);
        list.get(1).add(0);
        list.get(1).add(1);
        list.get(2).add(2);
        list.get(3).add(0);
    System.out.println(canVisitAllRooms(list));
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[]=new boolean[rooms.size()];
        Queue<Integer> q=new LinkedList();
        vis[0]=true;
        q.add(0);
        while(!q.isEmpty()){
            int u=q.poll();
            vis[u]=true;
            for(int v:rooms.get(u)){
                if(!vis[v]){
                    q.add(v);
                }
            }
        }
        for(boolean b:vis){
            if(!b)return false;
        }
        return true;
    }
}