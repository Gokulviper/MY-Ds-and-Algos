package Recursion.String;
import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(allSub("abc", "", new ArrayList<>()));
    }
    private static List<String> allSub(String s,String ans,List<String>list){
        if (s.isEmpty()){
         list.add(ans);
            return list;
        }
        allSub(s.substring(1),ans+s.charAt(0),list);
        allSub(s.substring(1),ans,list);
        return list;

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
