package BackTracking.Array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        recur(0,ans,nums);
        return ans;
    }

    private static void recur(int i, List<List<Integer>> ans, int[] nums) {

    }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}
