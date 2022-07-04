package String.SlidingWindow;

import java.util.Arrays;

public class LongestSubstringWithKRepratingCharacters {
    public static void main(String[] args) {
     String   s = "ababbc";int  k = 2;
    }
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] hash = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset hash
            Arrays.fill(hash, 0);
            int start = 0, end = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (end < str.length) {
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = str[end] - 'a';
                    if (hash[idx] == 0) unique++;
                    hash[idx]++;
                    if (hash[idx] == k) countAtLeastK++;
                    end++;
                }
                // shrink the sliding window
                else {
                    idx = str[start] - 'a';
                    if (hash[idx] == k) countAtLeastK--;
                    hash[idx]--;
                    if (hash[idx] == 0) unique--;
                    start++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    result = Math.max(end - start, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }
}
