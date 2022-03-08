package String.SlidingWindow;

class LongestSubStringOfAllVowelOrder {
    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
    public static int longestBeautifulSubstring(String word) {
         int cnt = 1;
        int len = 1;
        int max_len = 0;
        for (int i = 1; i != word.length(); ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++len;
            } else if (word.charAt(i - 1) < word.charAt(i)) {
                ++len;
                ++cnt;
            } else {
                cnt = 1;
                len = 1;
            }
            
            if (cnt == 5) {
                max_len = Math.max(max_len, len);
            }
        }
        return max_len;
    }
}