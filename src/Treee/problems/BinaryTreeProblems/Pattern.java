package Treee.problems.BinaryTreeProblems;

//import static jdk.nashorn.internal.objects.Global.print;

import javax.swing.text.AttributeSet;
import java.util.*;

public class Pattern {
    public static void main(String[] args) {
        int[] nums = {4, 4, 52, 5, 7, 9, 8, 22, 35};
        print(467876);
    }

    private static void shortestPath(int[] nums) {


    }

    private static String find(String s) {
        int j = s.length() - 1;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {


            if (Character.isLetter(s.charAt(i))) {
                while (j > 0 && !Character.isLetter(s.charAt(j))) {
                    j--;
                }
                ;
                ans += s.charAt(j);
                j--;
            } else {
                ans += s.charAt(i);
            }
        }
        return ans;
    }

    private static int add(int num1, Integer num2, Character sign) {
        if (sign == '+') return num1 + num2;
        if (sign == '-') return num1 - num2;
        if (sign == '*') return num1 * num2;
        return num1 / num2;
    }

    static void print(int n) {
        int size = 2 * n - 1;
//inner loop
        for (int i = 1; i <= size; i++) {
//outer loop
            for (int j = 1; j <= size; j++) {
//calculates and prints the values for pattern
                System.out.print(Math.max(Math.abs(i - n), Math.abs(j - n)) + 1 + " ");
            }
            System.out.println();
        }

    }
}
      








