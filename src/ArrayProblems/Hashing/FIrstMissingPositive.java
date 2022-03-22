package ArrayProblems.Hashing;

import java.util.Arrays;
import java.util.*;

class FIrstMissingPositive {
    public static void main(String[] args) {
        int[]nums={0,2,2,1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]);

            if(val > n){
                continue;
            }
            val = val - 1;
            if(nums[val] > 0){
                nums[val] *= -1;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
    public static int firstMissingPositive1(int[] nums) {
        //case 1:number smaller no in the array -return n
        //case 2:number in middle return n
        //number in after the array return n+1
        Arrays.sort(nums);
        int n=1;
        int i=0;
        for (;i<nums.length;i++){
            if (nums[i]<=0){
                continue;
            }
            if (i+1< nums.length&&nums[i] == nums[i + 1]){
                continue;

            }
            if(nums[i]!=n){
                return n;
            }else{
                n++;
            }
        }
        return n;
        
    }
    public int firstMissingPositive2(int[] nums) {
        Set<Integer> set=new HashSet();
        for(int num:nums){
            set.add(num);
        }
        int n=1;
        for(int i=0;i<nums.length;i++){
            if(set.contains(n)){
                n++;
            }else{
                return n;
            }
        }
        return nums.length+1;
    }
}