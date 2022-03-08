package ArrayProblems.SlidingWindow;

import java.util.*;

class ContainNearByDuplicates {
    public static void main(String[] args) {

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
               Set<Integer> set=new HashSet();
        int start=0;
        int end=0;
        while(end<nums.length){
            if(end-start>k){
                set.remove(nums[start]);
                start++;
            }
            if(set.contains(nums[end])){
                return true;
            }
            
            set.add(nums[end]);
            end++;
        }
        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        //time limit exceeded
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length&&i!=j;j++){
                if(nums[i]==nums[j]){
                    int check=Math.abs(i-j);
                    if(check<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}