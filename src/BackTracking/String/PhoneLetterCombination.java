package BackTracking.String;

import java.util.*;

public class PhoneLetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static String[] arr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>() ;
        }

        return recur("",digits,new ArrayList<>());
    }

    private static List<String> recur(String p, String up, ArrayList<String> ans) {
        if (up.isEmpty()){
            ans.add(p);
            return ans;
        }
        int digit=up.charAt(0)-'0';
        for (char c:arr[digit].toCharArray()) {
            recur(p+c,up.substring(1),ans);
        }
return ans;
    }
}
