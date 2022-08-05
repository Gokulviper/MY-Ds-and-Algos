package BackTracking.Array;

class PartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums)sum+=num;
        if(sum%k!=0)return false;
        sum/=k;
        boolean[]vis=new boolean[nums.length];
        return f(nums,k,sum,0,0,vis);
    }
    boolean f(int[]nums,int k,int target,int sum,int start,boolean[]vis){
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