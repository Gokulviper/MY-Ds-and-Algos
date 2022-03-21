package String.SlidingWindow;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
     String   s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
    public class Solution {
        public boolean checkInclusionOptimize(String s1, String s2) {
            if (s1.length() > s2.length())
                return false;
            int[] s1map = new int[26];
            int[] s2map = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1map[s1.charAt(i) - 'a']++;
                s2map[s2.charAt(i) - 'a']++;
            }

            int count = 0;
            for (int i = 0; i < 26; i++)
                if (s1map[i] == s2map[i])
                    count++;

            for (int i = 0; i < s2.length() - s1.length(); i++) {
                int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
                if (count == 26)
                    return true;
                s2map[r]++;
                if (s2map[r] == s1map[r])
                    count++;
                else if (s2map[r] == s1map[r] + 1)
                    count--;
                s2map[l]--;
                if (s2map[l] == s1map[l])
                    count++;
                else if (s2map[l] == s1map[l] - 1)
                    count--;
            }
            return count == 26;
        }
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
    public static  boolean checkInclusion1(String s1, String s2) {

        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }

    public static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}
