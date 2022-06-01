package DynamicProgramming.LIS;

import java.util.*;

class LargestDivisibleSubset {
	public static void main(String[] args) {
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
	List<List<Integer>> outerSubset = new ArrayList<>();
	Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
		List<Integer> currentSubset = new ArrayList<>();
		for (int j = 0; j < i; j++) {
			if (nums[i] % nums[j] == 0&&outerSubset.get(j).size() > currentSubset.size()) {

					currentSubset = outerSubset.get(j);
			}
		}
		outerSubset.add(new ArrayList<>(currentSubset));
		outerSubset.get(i).add(nums[i]);
		if (outerSubset.get(i).size() > max.size()) {
			max = outerSubset.get(i);
		}
	}
	return max;
    }
}