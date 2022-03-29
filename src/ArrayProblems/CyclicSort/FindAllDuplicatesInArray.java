package ArrayProblems.CyclicSort;

import java.util.*;

class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[]nums={4,3,2,7,8,2,3,1};
        //1,2,2,3,3,4,7,8
    }
    public static List<Integer> findDuplicates(int[] nums) {
        sort(nums);
        List<Integer>ans=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    private static void sort(int[]nums) {
        int i = 0;

        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else i++;
        }
    }
        static   void swap(int[]nums,int a,int b){
            int t=nums[a];
            nums[a]=nums[b];
            nums[b]=t;
        }
    public static List<Integer> findDuplicates1(int[] nums) {
            Map<Integer,Integer> map=new HashMap();
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            List<Integer> ans=new ArrayList();
            for(int num:nums){
                if(map.get(num)>1){
                    ans.add(num);
                    map.put(num,map.getOrDefault(num,0)-1);
                }
            }
            return ans;
        }
    }
}