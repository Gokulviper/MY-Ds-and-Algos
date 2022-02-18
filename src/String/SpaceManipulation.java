package String;

public class SpaceManipulation {
    public static void main(String[] args) {
       String s = "LeetcodeHelpsMeLearn";int [] spaces = {8,13,15};
        System.out.println(addSpaces(s,spaces));
    }
    public static String addSpaces(String s, int[] spaces) {
        //we makes spaces on the string
        //pretty easy straight forward

        StringBuilder sb=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(j<spaces.length&&spaces[j]==i){
                sb.append(" ");
                i-=1; //because we want and the but next iteration i will increase so the decrement are
                j++;
            }else{
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }
}
