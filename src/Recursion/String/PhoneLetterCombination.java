package Recursion.String;

import javax.naming.ldap.SortResponseControl;
import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static String[] arr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<String>();
        return combination("", digits,new ArrayList<>());
    }
    static ArrayList<String> combination(String p, String unp,ArrayList ans) {

        if (unp.isEmpty()) {
            ans.add(p);
            return ans;
        }
        int digit = unp.charAt(0) - '0';
        for (char c : arr[digit].toCharArray()){
        combination(p + c, unp.substring(1),ans);
        }
        return  ans;
    }
}
