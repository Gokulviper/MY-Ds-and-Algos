package DynamicProgramming.String;

class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][]dp=new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return f(strs,m,n,0,dp);
    }
    int f(String[]str,int m,int n,int i,int[][][]dp){
        if(i>=str.length)return 0;
        if(m==0&&n==0)return 0;
        if(dp[i][m][n]==-1){
            int onesCount=ones(str[i]);
            int zerosCount=zeros(str[i]);
            int pick=0;
            if(zerosCount<=m&&onesCount<=n){
                pick=1+f(str,m-zerosCount,n-onesCount,i+1,dp);
            }
            int npick=f(str,m,n,i+1,dp);
            dp[i][m][n]= Math.max(pick,npick);
        }
        return dp[i][m][n];
    }
    int ones(String s){
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch=='1')count++;
        }
        return count;
    }
    int zeros(String s){
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch=='0')count++;
        }
        return count;
    }
}