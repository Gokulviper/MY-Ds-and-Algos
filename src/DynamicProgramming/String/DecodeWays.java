package DynamicProgramming.String;

public class DecodeWays {
    public static void main(String[] args) {
        String s="121";
        ;
    }
    static int tabulation(String s){
        if (s.charAt(0)=='0')return 0;
        int[]dp=new int[s.length()+1];
        dp[s.length()]=1;
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)!='0') {
                int ans = 0;
                ans = dp[i + 1];
                if (i < s.length() - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    ans += dp[i + 2];
                }
                dp[i] = ans;
            }
        }
        return dp[0];
    }
    static int decodeWays(String s,int i,int[]dp){
        if(i==s.length())return 1;
        if (i>s.length())return 0;
        if (s.charAt(i)=='0')return 0;
        if(dp[i]==-1){
            int ans=0;
            ans+=decodeWays(s,i+1,dp);
            if(s.charAt(i)=='1'||(i<s.length()-1&&s.charAt(i)=='2'&&s.charAt(i+1)<'7')){
                ans+=decodeWays(s,i+2,dp);
            }
            dp[i]= ans;
        }
        return dp[i];
    }
}
