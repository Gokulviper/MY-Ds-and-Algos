package DynamicProgramming.Array;

public class MaximumSubArray {
    //kadanes algorithm
    public static void main(String[] args) {

    }
    public static int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int sum=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            sum=Math.max(sum,nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
    public static int maxSubArrayDivideAndConquer(int[] nums) {


        return checkSubarray(nums, 0, nums.length - 1);

    }

    public static int checkSubarray(int[] arr, int low, int high) {

        if (low > high) {
            return Integer.MIN_VALUE;
        }
        if (low == high) {
            return arr[low];
        }
        int mid = low + (high - low) / 2;
        int maxRight = 0;
        int maxLeft = 0;
        int sum = 0;
        int i = 0;
        for (i = mid - 1; i >= low; i--) {
            sum = sum + arr[i];
            if (sum > maxLeft) {
                maxLeft = sum;
            }
        }
        sum = 0;

        int j = 0;
        for (j = mid + 1; j <= high; j++) {
            sum = sum + arr[j];
            if (sum > maxRight) {
                maxRight = sum;
            }
        }

        int sumCombined = maxLeft + maxRight + arr[mid];
        int sumLeft = checkSubarray(arr, low, mid);
        int sumRight = checkSubarray(arr, mid + 1, high);

        return Math.max(sumCombined, Math.max(sumRight, sumLeft));

    }
}
