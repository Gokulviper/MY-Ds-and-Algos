package Recursion.String;
import java.util.ArrayList;
public class SubSequence {
    public static void main(String[] args) {
        System.out.println(subseq("abc", "", new ArrayList<>()));
    }
    private static ArrayList subseq(String s, String ans, ArrayList list) {
        if (s.isEmpty()){
            list.add(ans);
            return list;
        }
        subseq(s.substring(1),ans+s.charAt(0),list);
        subseq(s.substring(1),ans,list);
             return list;
    }
}
