package DynamicProgramming.Array;

public class SubsetSumDividesm {
    public static void main(String[] args) {
        int nums[]={3,6};
        System.out.println(memorzation(nums,0,0,4,new int[nums.length]));
    }

    private static boolean memorzation(int[] nums, int index, int sum, int m,int[]dp) {
        if (index == nums.length) {
            return  dp[index]%m==0;
        }
        if (dp[index]!=0)return dp[index]%m==0;

        boolean pick=memorzation(nums,index+1,sum+nums[index],m,dp);
        boolean notPick=memorzation(nums,index+1,sum,m,dp);
        if (pick)dp[index]=nums[index]+sum;
        else dp[index]=sum;
        return dp[index]%m==0;
    }

    private static boolean getAns(int[] nums, int index, int sum, int m) {
        if (index==nums.length){
            if (sum>0&&sum%m==0){
                return true;
            }
            return false;
        }
        boolean pick=getAns(nums,index+1,sum+nums[index],m);
        boolean notPick=getAns(nums,index+1,sum,m);
        return pick||notPick;
    }
}
