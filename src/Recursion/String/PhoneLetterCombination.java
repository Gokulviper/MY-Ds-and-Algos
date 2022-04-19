package Recursion.String;

import javax.naming.ldap.SortResponseControl;
import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("12"));
    }

    static String[] arr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<String>();
        return combination("", digits);
    }
    static ArrayList<String> combination(String p, String unp) {
        ArrayList<String> list = new ArrayList<String>();
        if (unp.isEmpty()) {
            list.add(p);
            return list;
        }
        int digit = unp.charAt(0) - '0';
        for (char c : arr[digit].toCharArray())
            list.addAll(combination(p + c, unp.substring(1)));
        return  list;
    }
}
