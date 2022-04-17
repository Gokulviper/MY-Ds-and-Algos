package Recursion.String;

public class Basic {
    public static void main(String[] args) {
        System.out.println( removeAllTheGivenWord("gokaakoaa","","kaak"));
    }

    private static String removeAllTheGivenWord(String s, String ans, String target) {
        if (s.isEmpty()){
            return ans;
        }
        if (s.startsWith(target)){
            return removeAllTheGivenWord(s.substring(target.length()), ans, target);
        }
        return removeAllTheGivenWord(s.substring(1),ans+s.charAt(0),target);
    }

    private static String removeAllTheGivenLetter(String s, String ans, char target) {
        if (s.isEmpty()){
            return ans;
        }
        if (s.charAt(0)!=target){
            ans+=s.charAt(0);
        }
        return removeAllTheGivenLetter(s.substring(1),ans,target);
    }

}
