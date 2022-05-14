package ArrayProblems.Subsequnce;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LongestSubSequnce {
    public static void main(String[] args) {

    }
    public static int longestConsecutive(int[] nums) {
        /*
         the logic: if(!num_set.contains(num-1)).
That means, for example, 6,5,4,3,2,1 input, only the value 1 is valid for the loop(all other values have its value - 1 in the set), that is O(n).
Another corner example, 2, 5, 6, 7, 9, 11. All of these numbers are the "entrance" for the logic but the while loop doesn't run much. That is O(n) as well.
         */
        if (nums.length==0)return 0;;
        int max=0;
        Set<Integer>set=new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        for (int num:nums) {
            if (!set.contains(num - 1)) {
                int current_num = num;
                int current_length = 1;
                while (set.contains(current_num + 1)) {
                    current_length++;
                    current_num++;
                }
                max = Math.max(max, current_length);
            }
        }
        return max;

    }
    public static int longestConsecutiveBetter(int[] nums) {
        if(nums.length==0)return 0;

        Arrays.sort(nums);
        int current_length=1;
        int max_length=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i]==nums[i-1]+1){
                    current_length+=1;

                }else {
                    max_length=Math.max(max_length,current_length);
                    current_length=1;
                }
            }
        }
        return Math.max( max_length,current_length);

    }
    public static int longestConsecutiveBrute(int[] nums) {
      int max=0;
      for (int num:nums){
          int current_Num=num;
          int current_length=1;
          while (contain(nums,current_Num+1)){
              current_length++;
              current_Num++;
          }
          max=Math.max(max,current_length);
      }
      return max;
    }

    private static boolean contain(int[] nums, int target) {
        for (int num:nums){
            if (num==target){
                return true;
            }
        }
        return false;
    }

}