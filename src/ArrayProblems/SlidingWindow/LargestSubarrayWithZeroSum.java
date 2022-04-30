package ArrayProblems.SlidingWindow;

class LargestSubarrayWithZeroSum
{
    public static void main(String[] args) {
        int A[] = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(A, A.length));
    }
  static   int maxLen(int nums[], int n)
    {
   int left=0,right=0,max=0,sum=0;
   for (;right< nums.length;right++){
       sum+=right;
       if (sum==0){
           max=Math.max(right-left+1,max);
       }
   }
   return max;
    }
}