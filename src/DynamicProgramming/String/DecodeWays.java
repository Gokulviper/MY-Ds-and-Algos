package DynamicProgramming.String;

public class DecodeWays {
    public static void main(String[] args) {
        String s="121";

    }
    static int tabulation(String s){
        int[]dp=new int[s.length()+1];

        dp[s.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0')continue;
            int one=dp[i+1];
            int two=0;
            if(i<s.length()-1){
                int num=Integer.parseInt(s.substring(i,i+2));
                if(num<=26){
                    two=dp[i+2];
                }
            }
            dp[i]= one+two;
        }
        return dp[0];
    }
    static int decodeWays(String s,int i,int[]dp){
       if (i==s.length())return 1;
       if (s.charAt(i)=='0')return 0;
       if (dp[i]==-1){
           int one=decodeWays(s,i+1,dp);
           int two=0;
           if (i<s.length()-1){
               int num=Integer.parseInt(s.substring(i,i+2));
               if(num<=26) {
                   two = decodeWays(s, i + 2, dp);
               }
           }
         return   dp[i]=one+two;
       }
       return dp[i];
    }
}
