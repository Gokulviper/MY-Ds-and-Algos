package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findDubplicateNumber {
    public static void main(String[] args) {
   int[]arr={1,3,4,2,2};
        System.out.println(findDuplicat3(arr));
    }
    public static   int findDuplicate(int[] nums) {
        //brute force time limit exceeeded
        int count=0;
        int  ans=0;
        for(int i=0;i<nums.length;i++){
            count=0;
            for(int j=0;j<nums.length;j++){

                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>1){

                ans=nums[i];
                break;
            }
        }
        return ans;
    }
    public static   int findDuplicate1(int[] nums) {
        //better brute force
        //n(log(n))
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
    public static   int findDuplicat3(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans=0;
      for(int i=0;i<nums.length;i++){
          int check=map.get(nums[i]);
          if(check>1){
             return nums[i];
          }
      }
      return 0;

    }

}
