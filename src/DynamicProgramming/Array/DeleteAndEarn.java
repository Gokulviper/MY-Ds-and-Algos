package DynamicProgramming.Array;

import java.util.*;
/*
If you haven't done LC.198 House Robber and LC.213 House Robber II,
I'd strongly recommend you to do these two problems first.
This problem, Delete and Earn, is an extension to House Robber
but with the different problem description. My solution and explanation
below is assumed you've completed House Robber problem already.

First, we need to create a hashMap to record how many points we have for each number in nums[ ]
 because we might have duplicates. Also, we need to have a variable "maxNumber" to track what's
 the max number in nums[ ].

Let's say we have nums = [7, 7, 3, 3, 4]. Then how do our hashMap look like? It would be like
hashMap : 7 = 14, 3 = 6, 4 = 4. Also we would have maxNumber = 7. Then in the next for-loop,
we can simply treat the problem as House Robber exactly.
 But you might have a question in mind that how do we deal with the number missing in has****hMap
 between 0 to maxNumber? Okay, let's look the examples below.

0 1 2 3 4 5 6 7 ---> house idx
0 0 0 6 4 0 0 14 ---> points

When the robber arrived to idx 0 house, since we don't have such a house, we treate it as 0.
 We don't have a house there so robber can only have 0 points at idx 0. It's same as idx 1.
  When robber came to idx 1, he can only have 0 points because there's no house at idx 1.

The reason why we can see this problem almost same as House Robber problem because when we
delete a element nums[n], we can not take nums[n-1] and num[n+1].
That means we can not take element that is connected to nums[n]. Isn't it the House Robber problem?
 */
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
 int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+num);
            max=Math.max(max,num);
        }
        int[]dp=new int[max+1];
        dp[0]=0;
        dp[1]=map.getOrDefault(1,0);
        for(int i=2;i<=max;i++){
            int points=map.getOrDefault(i,0);
            dp[i]=Math.max(dp[i-1],points+dp[i-2]);
        }
        return dp[max];
    }
}