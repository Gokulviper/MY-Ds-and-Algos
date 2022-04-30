package ArrayProblems.SlidingWindow;

import java.util.HashMap;

class LargestSubarrayWithZeroSum
{
    public static void main(String[] args) {
        int A[] = {-1,1,2,-2,7,-7,4,5,0,-2,2};
        System.out.println(maxLen(A, A.length));
    }
  static   int maxLen(int nums[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int max=0;
        for (int i = 0; i <n ; i++) {
            sum+=nums[i];
            if (sum==0){
                //if this directly reach the zero so the sequence numbers give the sum of zero
                max=i+1;
            }else{
                if(map.containsKey(sum)){
                        max=Math.max(max,i-map.get(sum));
                }else {
                    map.put(sum,i);
                }
            }
        }
        return max;
    }
}