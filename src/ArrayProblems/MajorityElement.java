package ArrayProblems;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        //brute force
        int majcount=nums.length/2;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>majcount){
                return nums[i];
            }
        }
        return -1;

    }
    public int majorityElement1(int[] nums) {
        int majcount=nums.length/2;
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.get(num)>majcount){
                return num;
            }
        }
        return -1;

    }
}
