package ArrayProblems.Hashing;

import java.util.Arrays;

class FIrstMissingPositive {
    public static void main(String[] args) {
        int[]nums={0,2,2,1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
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
}