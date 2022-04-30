package BackTracking.Array;

import java.util.*;

class SubSets2 {
    public static void main(String[] args) {
        int[]nums={1,2,2};
        subsetsWithDup(nums);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>>  ans=new ArrayList();
        Arrays.sort(nums);
        r(0,nums,ans,new ArrayList());
        return ans;
    }
    private static void  r(int start,int[]nums,List<List<Integer>> ans,List<Integer> list){
        if(list.size()<=nums.length){
            ans.add(new ArrayList(list));
          
        }
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            r(i+1,nums,ans,list);
            list.remove(list.size()-1);
        }
    }
}