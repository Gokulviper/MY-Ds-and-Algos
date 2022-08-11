package DynamicProgramming;

class NumsOfRollsDice {
     private final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        return f(n,k,target);
    }
    int f(int n,int faces,int target){
        if(target==0)return 1;
        if(target<0)return 0;
        if(n==0)return target==0?1:0;
        int ans=0;
        for(int i=1;i<=faces;i++){
            ans=(ans+f(n-1,faces,target-i))%MOD;
        }
        return ans;
    }
}