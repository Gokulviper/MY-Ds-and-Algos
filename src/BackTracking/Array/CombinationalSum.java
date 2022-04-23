package BackTracking.Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {
    public static void main(String[] args) {
      int[]nums={2,3,6,7};int target=7;
        System.out.println(combinationSum(nums,7));
    }
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
                List<List<Integer>> ans=new ArrayList<>();
                List<Integer>list=new ArrayList<>();
                recur(0,nums,target,ans,list);
                return ans;
        }

        private static void recur(int start, int[] nums, int target, List<List<Integer>> ans, List<Integer> list) {
            if(target==0||target<0){
                if(target==0){
                   ans.add(new ArrayList(list));


                }
                return;
            }
            for(int i=start;i<nums.length;i++)  {
                if(target<nums[i]){
                    continue;
                }
                list.add(nums[i]);
                recur(i,nums,target-nums[i],ans,list);
                list.remove(list.size()-1);
            }
        }
    }
