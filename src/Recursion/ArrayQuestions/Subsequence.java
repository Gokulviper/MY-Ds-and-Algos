package Recursion.ArrayQuestions;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {

        System.out.println( subset(new int[]{1,2,3}));
    }

    private static List<List<Integer>> subset(int[] nums) {
        List<List<Integer> >outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num:nums) {
            int n=outer.size();
            for (int i = 0; i <n; i++) {
              List<Integer> internal=new ArrayList<>(outer.get(i));
              internal.add(num);
              outer.add(internal);
            }
        }
        return outer;
    }

}
