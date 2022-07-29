package DynamicProgramming.String;
/*
: Expand Around Center
Algorithm :
This is an expansion around the Center Technique.
This is the Best efficient approach to Solve this Problem. Technically there is another algorithm Called Manacher’s Algorithm O(N). It will be hard to implement it in a live interview Session.
The idea behind the expansion around the Center technique.
Go to Each index and expand left and right and check whether they are equal. Return the difference in the length of the palindrome for each index.
If it is greater than the previous element. Make it the Longest Palindrome.
Repeat it for each element.
At the End of the traversal, Return the Longest Palindrome Substring.
 */
class LongestpallindramicSubString {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

    }
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        
        int start = 0;
        int end = 0;
        
        for(int i = 0 ; i<s.length() ; i++){
            int len1 = expandAroundCenter(s, i, i); // assume odd length and try to expand Palindrome as possible
            int len2 = expandAroundCenter(s, i, i+1); // assume even length 
            int len = Math.max(len1, len2);
            if(len > end-start){
                start = i-((len-1)/2);
                end = i + (len/2);
            }
        }
        return s.substring(start, end+1);
    }
    
    private static int expandAroundCenter(String s, int left , int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public String longestPalindrome1(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}

// Time Complexity : O(N^2). Since expanding a palindrome around its center could take O(N) time, the overall complexity is O(N^2)

// Space Complexity : O(1)