package Recursion;

public class BasicPrograms {
    public static void main(String[] args) {
       int[]nums={4,5,8,99,245,576,999};
        System.out.println(binarysearch(nums,9,0,nums.length-1));
    }

    private static int binarysearch(int[] nums, int target, int start, int end) {
        if (start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if (target==nums[mid]){
            return mid;
        }
        if (nums[mid]<target){
            return binarysearch(nums,target,mid+1,end);
        }
        return binarysearch(nums,target,start,mid-1);
    }

    private static String reverse(String s, String ans) {
        if (s.isEmpty()){
            return ans;
        }
    return reverse(s.substring(1),s.charAt(0)+ans);
    }

    private static void printNumbers(int n) {
        if (n<=0){
            return;
        }
        printNumbers(n-1);
        System.out.println(n);
    }
    private static int fibo(int n){
        if (n<2)return n;


       return  fibo(n-1)+  fibo(n-2);
    }
}

