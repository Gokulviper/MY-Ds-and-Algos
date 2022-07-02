package HEAP.MaxHeap;

import java.util.Arrays;
import java.util.HashMap;


class TopKFrequentElements {
    public static void main(String[] args) {
        int[]nums={1};
        int k=1;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        MaxPqN pq=new MaxPqN(nums.length+1);
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num: map.keySet()){
            pq.insert(num,map.get(num));
        }
        int[]ans=new int[k];
          for (int i=0;i<k;i++){
              ans[i]=pq.poll();
          }
   return ans;
    }
}