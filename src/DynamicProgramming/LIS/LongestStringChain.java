package DynamicProgramming.LIS;

import java.util.Arrays;

class LongestStringChain {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a, b)->(a.length() - b.length()));
        
        // System.out.print(Arrays.toString(words));
        
        int n = words.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int max = 1;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(compare(words[i], words[j]) == true && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    
    public boolean compare(String str1, String str2) {
        if(str1.length() != str2.length() + 1) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while(i < str1.length()) {
            if(j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        
        return (i == str1.length() && j == str2.length());
    }
}