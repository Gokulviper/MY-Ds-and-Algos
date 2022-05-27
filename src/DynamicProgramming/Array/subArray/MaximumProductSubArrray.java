package DynamicProgramming.Array.subArray;

class MaximumProductSubArrray {
 /*   If this question consist of only positive integer, then this question would be very easy,
  just return the product of all integer.

However, it contain negative integer,
 while negative - negative product would result in a positive number, so we can't return product of all integer,
  or just calculate the product of positive integer.

Therefore, we create two dp, one save the maximum product from 0 to i,
and the other one save the minimum product from 0 to i. And for each dp update,
 we calculate the product of both maximum product * nums[i] and minimum prodcut * nums[i], just in case
 if nums[i] is negative and it form a larger positive product when minimum prodcut * nums[i].*/
    public int maxProduct(int[] nums) {
        int[]max=new int[nums.length];
        int []min=new int[nums.length];
        max[0]=min[0]=nums[0];
        int ans=nums[0];
        for (int i = 1; i <nums.length ; i++) {
           max[i]=Math.max(Math.max(nums[i],nums[i]*max[i-1]),nums[i]*min[i-1]);
            min[i]=Math.min(Math.min(nums[i],nums[i]*max[i-1]),nums[i]*min[i-1]);
            ans=Math.max(max[i],ans);
        }
        return ans;
    }
}