package ArrayProblems.SlidingWindow;

import java.util.*;

class BinarySubArrayWithGiveSum {
    public static void main(String[] args) {

    }
    public int numSubarraysWithSum(int[] nums, int target) {
      Map<Integer,Integer> map=new HashMap();
        int count=0;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
         count += map.getOrDefault(sum-target, 0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}