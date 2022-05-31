package ArrayProblems;

class TrappingRainWater {
    public static void main(String[] args) {

    }
    //dp
    public int trap(int[] nums) {
        int n=nums.length;
        int[]max_a=new int[n];
         int[]min_a=new int[n];
        max_a[0]=nums[0];
        int max=0;
        for(int i=1;i<n;i++){
            if(i!=0){
         
           max_a[i]=Math.max(nums[i],max_a[i-1]);
                }
        }
        min_a[n-1]=nums[n-1];
        int min=0;
          for(int i=n-2;i>=0;i--){
            if(i!=n-1){
         
            min_a[i]=  Math.max(nums[i],min_a[i+1]);
                }
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            int h=Math.min(max_a[i],min_a[i]);
            ans+=Math.abs(h-nums[i]);
        }
        return ans;
    }
}