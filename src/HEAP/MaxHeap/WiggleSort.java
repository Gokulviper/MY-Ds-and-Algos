package HEAP.MaxHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WiggleSort {
    public static void main(String[] args) {
        int[]nums={5,2,1,5,6,7,82,12};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void wiggleSort(int[] nums) {
   PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
        }
        for(int i=1;i<nums.length;i+=2){
            nums[i]=pq.poll();
        }
        for(int i=0;i<nums.length;i+=2){
            nums[i]=pq.poll();
        }

    }
}
