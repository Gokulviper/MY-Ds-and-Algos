package DynamicProgramming.LIS;

import java.util.*;

class LargestDivisibleSubset {
	public static void main(String[] args) {
		System.out.println(8%4);
		int[]nums={1,2,4,8};
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
		Arrays.sort(nums);
		List<Integer> al=new ArrayList<>();
		int max=1;
		int lis[]=new int[nums.length];
		Arrays.fill(lis,1);
		for(int i=1;i<nums.length;i++){
			//lis[i]=1;
			for(int j=0;j<i;j++){

				if(nums[i]%nums[j]==0&&1+lis[j]>=lis[i]){
					lis[i]=Math.max(lis[i],lis[j]+1);
					if(max<lis[i])max=lis[i];
				}}}
		int pre=-1;
		for(int i=nums.length-1;i>=0;i--){
			if(lis[i]==max&&(pre==-1||pre%nums[i]==0)){
				al.add(nums[i]);
				max=max-1;
				pre=nums[i];
			}}
		return al;
    }
}