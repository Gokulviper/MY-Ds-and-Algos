package BackTracking.Array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[]nums={1,2,3};
        System.out.println( permute(nums));

    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        recur(0,ans,nums);
        return ans;
    }

    private static void recur(int i, List<List<Integer>> ans, int[] nums) {
   if (i==nums.length){
       ArrayList<Integer> list=new ArrayList();
       for (int j=0;j<nums.length;j++){
           list.add(nums[j]);
       }
       ans.add(list);
       return;
   }
   for (int j=i;j<nums.length;j++){
       swap(nums,i,j);
       recur(i+1,ans,nums);
       swap(nums,i,j);
   }

    }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}
