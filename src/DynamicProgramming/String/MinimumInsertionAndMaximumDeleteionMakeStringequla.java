package DynamicProgramming.String;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
you have two strings abdcf and anu
first find the what is both common part using lcs
so get the lcs - string 2 =insertions
lcs - string=deletion
return insertion and deletions

 */
class MinimumInsertionAndMaximumDeleteionMakeStringequla {

static int lcs(String s1, String s2) {
    
    int n=s1.length();
    int m=s2.length();

    int dp[][]=new int[n+1][m+1];
    for(int rows[]: dp)
    Arrays.fill(rows,-1);
    for(int i=0;i<=n;i++){
        dp[i][0] = 0;
    }
    for(int i=0;i<=m;i++){
        dp[0][i] = 0;
    }
    
    for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
            else
                dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    
    return dp[n][m];
}

static int canYouMake(String str1, String str2){
    
    int n = str1.length();
    int m = str2.length();
    
    int k = lcs(str1,str2);
    
    return (n-k)+(m-k);
}

public static void main(String args[]) {

  String str1= "abcd";
  String str2= "anc";
//  System.out.println("The Minimum operations required to convert str1 to str2: "
 // +canYouMake(str1,str2));
    String s="12345*+-+";
    System.out.println(find(s));
}

    private static int find(String s) {
    int ans=s.charAt(0)-'0';
    int j=1;

        for (int i=1;i<s.length();i++){
            if (!Character.isDigit(s.charAt(i))){
                if (s.charAt(i)=='*')ans*=s.charAt(j)-'0';
                else if (s.charAt(i)=='/')ans/=s.charAt(j)-'0';
                else if (s.charAt(i)=='-')ans-=s.charAt(j)-'0';
                else ans+=s.charAt(j)-'0';
                j++;
            }
        }
        return ans;
    }
}