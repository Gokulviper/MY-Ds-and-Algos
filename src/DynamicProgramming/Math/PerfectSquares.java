package DynamicProgramming.Math;

import java.util.*;

class PerfectSquares {
    public int numSquares(int n) {
        if(n <= 1)
            return n;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i*i <= n; i++) {
            list.add(i*i);
        }
        
        return recurion(list, list.size() - 1, n);
    }
    
    private int recurion(List<Integer> list, int index, int target) {
        if(index==0){
            return target%list.get(0)==0?target/list.get(0):0;
        }
        int notPick = recurion(list, index-1, target);
        
        int pick = Integer.MAX_VALUE;
        if(target >= list.get(index))
            pick = 1 + recurion(list, index, target - list.get(index));
        
        return Math.min(notPick, pick);
    }
    public int memo(int n) {
        if(n<=3)return n;
        int[][]dp=new int[n+1][n+1];
        for(int[]r:dp)Arrays.fill(r,-1);
        List<Integer> list=new ArrayList();
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }
        return f(list,list.size()-1,n,dp);
    }
    int f(List<Integer> list,int i,int target,int[][]dp){
        if(i==0){
            return target%list.get(0)==0?target/list.get(0):0;
        }
        if(dp[i][target]==-1){
            int npick=f(list,i-1,target,dp);
            int pick=Integer.MAX_VALUE;
            if(list.get(i)<=target)
                pick=1+f(list,i,target-list.get(i),dp);
            dp[i][target]= Math.min(npick,pick);
        }
        return dp[i][target];
    }
    public int tabulation(int n) {
        if(n<=3)return n;
        List<Integer> list=new ArrayList();
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }
        int[][]dp=new int[list.size()][n+1];

        for(int i=0;i<=n;i++){
            if(i%list.get(0)==0){
                dp[0][i]=i/list.get(0);
            }
        }
        for(int i=1;i<list.size();i++){
            for(int j=1;j<=n;j++){
                int npick=dp[i-1][j];
                int pick=Integer.MAX_VALUE;
                if(list.get(i)<=j){
                    pick=1+dp[i][j-list.get(i)];
                }
                dp[i][j]=Math.min(pick,npick);
            }
        }

        return dp[list.size()-1][n];
    }
    public int space(int n) {
        if(n<=3)return n;
        List<Integer> list=new ArrayList();
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }

        int[]prev=new int[n+1];
        int[]cur=new int[n+1];

        for(int i=0;i<=n;i++){
            if(i%list.get(0)==0){
                prev[i]=i/list.get(0);
            }
        }
        for(int i=1;i<list.size();i++){
            for(int j=1;j<=n;j++){
                int npick=prev[j];
                int pick=Integer.MAX_VALUE;
                if(list.get(i)<=j){
                    pick=1+cur[j-list.get(i)];
                }
                cur[j]=Math.min(pick,npick);
            }
            prev=cur;
        }

        return prev[n];
    }

}