package String.SlidingWindow;

import java.util.Arrays;

public class sol {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        int n=nums.length;
        for (int i = 0; i <n ; i++) {
            if (nums[i]%7==0){
                nums[i]=nums[i+1]+1;
            }else if(nums[i]*2>12){
                nums[i-1]=nums[i]+nums[i-1];
                break;
            }else{
                    nums[i]=nums[i]-1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
