package ArrayProblems;

class TrappingRainWater {
    public static void main(String[] args) {

    }
    public int trapOptimized(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, res = 0, maxLeft = 0, maxRight = 0;
        while (left <right) {
            if (nums[left] <= nums[right]) {
                if (nums[left] >= maxLeft) {
                    maxLeft = nums[left];
                } else {
                    res += maxLeft - nums[left];
                }
                left++;
            } else {
                if (nums[right] >= maxRight) {
                    maxRight = nums[right];
                } else {
                    res += maxRight - nums[right];
                }
                right--;
            }
        }
        return res;
    }

    public int trap(int[] nums) {
        //idea
        /*
    maxLeft array=    find the all left previous grater elemet -traverse from left
    maxRight array=find all right greater element in array -traverse from right
    after you easy find the same index get the min of both left and right
    and add the answer current height - min_height
         */
        //dp approach
        int n=nums.length;
        int[]maxLeft=new int[n];
         int[]max_right=new int[n];
        maxLeft[0]=nums[0];  //there is no previous element you  make the first greater element
        for(int i=1;i<n;i++){
           maxLeft[i]=Math.max(nums[i],maxLeft[i-1]);
        }
        max_right[n-1]=nums[n-1];  //thrre is no next element find make  the last greater element
          for(int i=n-2;i>=0;i--){
            max_right[i]= Math.max(nums[i],max_right[i+1]);
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            int h=Math.min(maxLeft[i],max_right[i]);
            ans+=Math.abs(h-nums[i]);
        }
        return ans;
    }
}