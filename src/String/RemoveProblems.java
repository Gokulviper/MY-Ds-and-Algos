package String;

import java.util.*;

public class RemoveProblems {
    public static void main(String[] args) {
    }
    public String removeDuplicateLetters(String s) {
        Set set=new HashSet();
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        for(int i=0;i<ch.length;i++){
            set.add(ch[i]);
        }
        String ss="";
        List ans=new ArrayList();
        ans.addAll(set);
        for(int i=0;i<ans.size();i++){
           ss+= ans.get(i);

        }
        return ss;

    }
}
