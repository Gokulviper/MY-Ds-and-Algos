package ArrayProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementAllproblems {
    public static void main(String[] args) {
        int[]nums={1,2,3,4,3};
        nextGreaterElements(nums);

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //brute force
        int[]ans=new int[nums1.length];
        int k=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            int num=nums1[i];
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==num){
                    max=num;
                    while(j<nums2.length){
                        if(nums2[j]>max){
                            max=nums2[j];
                            break;
                        }
                        j++;
                    }
                }
            }
            ans[k++]=(max==num)?-1:max;

        }
        return ans;
    }
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer>map=new HashMap<>();
        for (int num:nums2){
            while (!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for (int i=0;i<nums1.length;i++){
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n]; // ans : nextgreater element

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            st.push(nums[i]);
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();


            st.push(nums[i]);
        }
        return ans;
    }
}
