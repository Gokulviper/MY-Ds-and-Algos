package DynamicProgramming.String;

public class PrintTheLongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(theSquece("abcede","bdeda"));
    }

    private static String theSquece(String s1, String s2) {
        int i=s1.length();
        int j=s2.length();
        StringBuilder sb=new StringBuilder();
        while (i>0&&j>0){
            if (s1.charAt(i-1)==s2.charAt(j-1)){
                sb.insert(0,s1.charAt(i-1));
                i--;j--;
            }else if(s1.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }else j--;
        }
        return sb.toString();

    }
}
