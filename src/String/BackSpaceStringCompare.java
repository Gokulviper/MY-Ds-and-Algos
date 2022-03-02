package String;

import java.util.Stack;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        //"a##c"
        //
      String  s = "a#c", t = "b";
        System.out.println(backspaceCompare(s,t));;
    }
    public static boolean backspaceCompare2(String s, String t) {
        int i=s.length()-1,j=t.length()-1;
        int skips=0,skipt=0;
        while (i>=0||j>=0){
            while (i>=0){
                if(s.charAt(i)=='#'){
                    skips++;
                    i--;
                }else if(skips>0){
                    i--;
                    skips--;
                }else break;
            }
            while (j>=0){
                if (t.charAt(j)=='#'){
                    skipt++;i--;
                }else if (skipt>0){
                    skipt--;
                    i--;
                }else break;
            }
            if (i>=0&&j>=0&&s.charAt(i)!=t.charAt(j)){
                return false;
            }
            if ((i>=0)!=(j>=0)){return false;}
            i--;
            j--;
        }
        return false;

    }
    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                }
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--; j--;
        }
        return true;
    }

    public static boolean backspaceCompare1(String s, String t) {
       String a= build(t);
     String b=   build(s);
     return a.equals(b);
        }

    private static String build(String t) {
            Stack stack=new Stack();
            StringBuilder sb=new StringBuilder();
            for (char ch:t.toCharArray()){
                if (ch!='#'){
                    stack.push(ch);
                }else{
                    if (!stack.isEmpty())
                   stack.pop();

                }
            }
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
    }


}
