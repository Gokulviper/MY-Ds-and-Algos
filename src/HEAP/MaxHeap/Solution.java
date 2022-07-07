package HEAP.MaxHeap;

import java.util.PriorityQueue;
class p{
    int square;
    int index;
    p(int square,int index){
        this.square=square;
        this.index=index;
    }
}
class KClosestPointstoOrgin {
    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<p>pq=new PriorityQueue<>((a,b)->b.square-a.square);
        for (int i = 0; i < points.length; i++) {
            int square=squarefinding(points[i]);
         if (pq.size()<k){
             pq.add(new p(square,i));
         }else if (square<pq.peek().square){
             pq.poll();
             pq.add(new p(square,i));
         }

        }
        int[][]ans =new int[k][2];
        for (int i=0;i<k;i++){
          int index=pq.poll().index;
          ans[i]=points[index];
        }
        return ans;
    }

    private int squarefinding(int[] point) {
        return point[0]*point[0]+point[1]*point[1];
    }
}