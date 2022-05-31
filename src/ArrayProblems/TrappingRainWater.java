package ArrayProblems;

class TrappingRainWater {
    public static void main(String[] args) {

    }
    public int trapOptimized(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, res = 0, maxLeft = 0, maxRight = 0;
        while (left <right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public int trap(int[] nums) {
        //dp approach
        int n=nums.length;
        int[]max_a=new int[n];
         int[]min_a=new int[n];
        max_a[0]=nums[0];
        for(int i=1;i<n;i++){
           max_a[i]=Math.max(nums[i],max_a[i-1]);
        }
        min_a[n-1]=nums[n-1];
          for(int i=n-2;i>=0;i--){
            min_a[i]=  Math.max(nums[i],min_a[i+1]);
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            int h=Math.min(max_a[i],min_a[i]);
            ans+=Math.abs(h-nums[i]);
        }
        return ans;
    }
}