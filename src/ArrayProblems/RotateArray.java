package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
        int nums[]={1,2,4,5,6,7,8,9};
     rotate2(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] rotate1(int[] nums,int k) {
        int[]ans=new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int v=0;
        int maintain=k;
        while (j>=0&&maintain-->0){
            ans[v++]=nums[j--];
        }
        while (i<=j){
            ans[v++]=nums[i++];
        }

        return ans;
    }
    private static void rotate2(int[] nums,int k) {
        int[]ans=new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int v=0;
        int maintain=k;
        while (j>=0&&maintain-->0){
            ans[v++]=nums[j--];
        }
        while (i<=j){
            ans[v++]=nums[i++];
        }
        nums=ans;

    }

    public void rotate(int[] nums, int k) {
        k=k%nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    public void reverse(int[]nums,int a,int b){
        while(a<b){
            int t=nums[a];
            nums[a]=nums[b];
            nums[b]=t;
            a++;
            b--;
        }
    }
}
