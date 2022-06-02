package DynamicProgramming.LIS;

import java.util.Arrays;
//idea is
//take the lis from right
//ake the lsi from the left
//plus the dp1[i]+dp2[i]-1 why -1 both have one common element
public class LongestBitonicSequnece {
    public static void main(String[] args) {

    }
    public int singleArraySpace(int[] nums) {
        int[]dp1=new int[nums.length];
        int[]dp2=new int[nums.length]      ;
        Arrays.fill(dp1,1);//beacuse the lowest increasing subseqence length is 1
      Arrays.fill(dp2,1);
        for (int i=0;i<nums.length;i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                }
            }
        }
        int max=0;
        for (int i= nums.length-1;i>=0;i--){
            for (int j=nums.length-1;j>i;j--){
                if(nums[i]>nums[j]){
                    dp2[i]=Math.max(dp2[i],1+dp2[j]);
                }
            }
            max=Math.max(max,dp2[i]+dp1[i]-1);}
        return max;
    }
}
