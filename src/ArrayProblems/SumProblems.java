package ArrayProblems;

import java.util.Arrays;
import java.util.*;
import java.util.Map;

public class SumProblems {
    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static int[] twoSum(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] == k) {
                break;

            } else if (nums[i] + nums[j] < k) {
                i += 1;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }

    public static int[] twoSum2(int[] nums, int k) {
        //using hashing
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (map.containsKey(k - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(k - nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i += 1) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int start = i + 1;
                int end = nums.length - 1;
                int sum = 0;
                while (start < end) {
                    sum = nums[i] + nums[start] + nums[end];
                    if (sum < 0) {
                        start += 1;
                    } else if (sum > 0) {
                        end--;

                    } else {
                        ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) start += 1;
                        while (start < end && nums[end - 1] == nums[end]) end--;
                        start++;
                        end--;
                    }
                }
            }
        }
        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest_sum = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int sum = 0;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    end--;
                } else {
                    start += 1;
                }
                if (Math.abs(sum - target) < diff) {
                    closest_sum = sum;
                    diff = Math.abs(sum - target);
                }
            }
        }
        return closest_sum;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i += 1) {
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                for (int j = i + 1; j < nums.length - 2; j += 1) {

                    if (j == i + 1 || (j > i + 1 && nums[j - 1] != nums[j])) {
                        int start = j + 1;
                        int end = nums.length - 1;
                        int sum = 0;
                        while (start < end) {
                            sum = nums[i] + nums[j] + nums[start] + nums[end];
                            if (sum == target) {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                while (start < end && nums[end] == nums[end - 1]) end--;
                                start++;
                                end--;
                            } else if (sum < target) {
                                start += 1;
                            } else {
                                end--;
                            }
                        }
                    }
                }
            }

        }
        return ans;

    }

}
