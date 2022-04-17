package Recursion.String;

public class Basic {
    public static void main(String[] args) {
        System.out.println( removeAllTheGivenLetter("gokaakoaa","",'k'));
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
