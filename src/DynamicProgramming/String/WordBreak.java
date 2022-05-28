package DynamicProgramming.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int[]dp=new int[s.length()];
        Arrays.fill(dp,-1);
       return memo(s,0,set,dp);
    }

    private boolean memo(String s, int i, Set<String> set, int[] dp) {
        if (i==s.length())return true;
        if (dp[i]==-1) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (set.contains(s.substring(i, j)) && memo(s, j, set,dp)) {
                    dp[i]=1;
                    return true;
                }else    dp[i]=0;
            }
        }
        return dp[i]==1;

    }

    private boolean f(String s, int i, Set<String> set) {
        if (i==s.length())return true;
        for (int j = i+1; j <=s.length() ; j++) {
       if (set.contains(s.substring(i,j))&&f(s,j,set)){
           return true;
       }
        }
        return false;
    }
}