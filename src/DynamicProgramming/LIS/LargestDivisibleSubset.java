package DynamicProgramming.LIS;

import java.util.*;

class LargestDivisibleSubset {
	public static void main(String[] args) {
		System.out.println(8%4);
		int[]nums={1,2,4,8,7,8,4,3,5};
		System.out.println(largestDivisibleSubset(nums));
	}
    /*
    Why sort?

if a <= b, then a % b = 0
we only need to validate b % a == 0
Why localMax?

for each number, we try to validate previous number
if current_number % previous_number == 0, then we can use their subset (localMax)
localMax with current number will be the current max
    */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        	List<Integer> max = new ArrayList<>();
	List<List<Integer>> outer = new ArrayList<>();
	Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
		List<Integer> inner = new ArrayList<>();
		for (int j = 0; j < i; j++) {
			if (nums[i] % nums[j] == 0&&outer.get(j).size() > inner.size()) {
					inner = outer.get(j);
			}
		}
		outer.add(new ArrayList<>(inner));
		outer.get(i).add(nums[i]);
		if (outer.get(i).size() > max.size()) {
			max = outer.get(i);
		}
	}
	return max;
    }
}