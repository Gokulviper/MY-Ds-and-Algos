package ArrayProblems.SlidingWindow;

import java.util.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        //nums = [], k = 3
        int[]nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
    public int[] maxSlidingWindowOptimize(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;
        // store index
        Deque< Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                ans[ansIndex++] = nums[q.peek()];
            }
        }
        return ans;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
    //    int[]ans=new int[nums.length-k];
        List<Integer>ans=new ArrayList<>();
        int start=0,end=k-1;
        int max=Integer.MIN_VALUE;
        for(;end<nums.length;end++){
            ans.add(find(nums,start,end));
            start++;
        }
    int[]arr=new int[ans.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=ans.get(i);
        }
        return arr;
    }
    static int  find(int[]nums,int start,int end){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
}