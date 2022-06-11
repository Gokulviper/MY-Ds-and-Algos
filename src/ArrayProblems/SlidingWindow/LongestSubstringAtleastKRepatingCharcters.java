package ArrayProblems.SlidingWindow;

import java.util.Arrays;

public class LongestSubstringAtleastKRepatingCharcters {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int i = 1; i <= maxUnique; i++) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int start = 0, end = 0, index = 0, unique = 0, count = 0;
            while (end < str.length) {
                // expand the sliding window
                if (unique <= i) {
                    index = str[end] - 'a';
                    if (countMap[index] == 0) unique++;
                    countMap[index]++;
                    if (countMap[index] == k) count++;
                    end++;
                }
                // shrink the sliding window
                else {
                    index = str[start] - 'a';
                    if (countMap[index] == k) count--;
                    countMap[index]--;
                    if (countMap[index] == 0) unique--;
                    start++;
                }
                if (unique == i && unique == count)
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
