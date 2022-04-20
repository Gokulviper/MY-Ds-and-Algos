package Recursion.String;

import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args) {
        System.out.println(dice("",4,new ArrayList<>()));

    }
    static ArrayList<String> dice(String p, int target, ArrayList<String>ans){
        if (target==0){
           ans.add(p);
            return ans;
        }
        for (int i = 1; i <=6&&i<=target ; i++) {
            dice(p+i,target-i,ans);
        }
        return ans;
    }
}
