package BackTracking.Array;

class PartitionKSubsets {
    public static void main(String[] args) {
        int[]nums={4,3,2,3,5,2,1};
        int k=2;
        System.out.println(canPartitionKSubsets(nums,4));
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums)sum+=num;
        if(sum%k!=0)return false;
        sum/=k;
        boolean[]vis=new boolean[nums.length];
        return f(nums,k,sum,0,0,vis);
    }
    /*
    flow of this loop bases recursion
    if you get enter into the number checks the fully run entre loop
    for finding next element-
     */
   static boolean f(int[]nums,int k,int target,int sum,int start,boolean[]vis){
        if(k==1)return true;
        if(sum>target)return false;
        if(sum==target){
           return f(nums,k-1,target,0,0,vis); 
        }
        for(int i=start;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                if(f(nums,k,target,sum+nums[i],i+1,vis))return true;
                vis[i]=false;
            }
        }
        return false;
    }
}