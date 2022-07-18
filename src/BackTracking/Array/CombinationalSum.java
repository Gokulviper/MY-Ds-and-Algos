package BackTracking.Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {
    public static void main(String[] args) {
      int[]nums={2,3,6,7};int target=7;
        System.out.println(combinationSum(nums,7));
    }


    public static List<List<Integer>> combinationSum(int[] nums, int target) {
                List<List<Integer>> ans = new ArrayList();

                f(nums, target, new ArrayList<>(), ans, 0);
                return ans;
            }

      static   void f(int[] nums, int target, List<Integer> list, List<List<Integer>> ans, int index) {
                if (index == nums.length) {
                    return;
                }
                if (target == 0) {
                    ans.add(new ArrayList<>(list));
                    return;
                }
                f(nums, target, list, ans, index + 1);
                if (nums[index] <= target) {
                    list.add(nums[index]);
                    f(nums, target - nums[index], list, ans, index);
                    list.remove(list.size() - 1);
                }

            }
        }
