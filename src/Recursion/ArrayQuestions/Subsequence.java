package Recursion.ArrayQuestions;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {

        System.out.println( subset(new int[]{1,2,3}));
    }
    private static List<List<Integer>> subsets(int[] nums) {
        List ans=new ArrayList();
        List list=new ArrayList();

            sum(nums,0,list,ans);
            return ans;
    }

    private static void sum(int[] nums, int index, List list, List ans) {
        if (list.size()<=nums.length){
            ans.add(new ArrayList<>(list));

        }
        for (int i = index; i <nums.length ; i++) {
            list.add(nums[i]);
            sum(nums,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }


    private static List<List<Integer>> subset(int[] nums) {
        List<List<Integer> >outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num:nums) {
            int n=outer.size();
            for (int i = 0; i <n; i++) {
              List<Integer> internal=new ArrayList<>(outer.get(i));
              internal.add(num);
              outer.add(internal);
            }
        }
        return outer;
    }

}
