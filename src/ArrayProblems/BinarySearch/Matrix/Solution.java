package ArrayProblems.BinarySearch.Matrix;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][]nums={{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(nums));
    }
    public static int maxEnvelopes(int[][] nums) {
        //incase we storing based on width (6,4)and (6,7)
        //you take the both that not a valid so idea is
        //if you the widh are equal so sort height into decending
        //otherewiase all other sort in ascending
        Arrays.sort(nums,(a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[]dp=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++){
            int index= ceil(dp,0,max,nums[i][1]);
            dp[index]=nums[i][1];
            if(index==max)max++;
        }
        return max;
    }
   static int ceil(int[]nums, int start, int end, int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}