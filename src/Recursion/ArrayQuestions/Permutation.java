package Recursion.ArrayQuestions;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(permutation("","abc"));

    }
    static ArrayList<String> permutation(String p, String up){
        if (up.isEmpty()){
       ArrayList<String>list=new ArrayList<>();
       list.add(p);
            return list;
        }
        ArrayList<String>ans=new ArrayList<>();
        for (int i = 0; i <=p.length() ; i++) {
            String f=p.substring(0,i);
            String e=p.substring(i,p.length());
       ans.addAll( permutation(f+up.charAt(0)+e,up.substring(1)));
        }
return ans;
    }
}
