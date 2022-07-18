package BitManipulations.Problems;

class FindTheDifference {
    public static void main(String[] args) {
        String  s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s,t));
    }
    public static char findTheDifference(String s, String t) {
        int num=0;
        if(s.isEmpty()&&t.isEmpty())return ' ';
        if(s.isEmpty()){
            num=t.charAt(0);
        }else
            num=s.charAt(0);
        for (int i = 1; i <s.length() ; i++) {
            num^=s.charAt(i);
        }
        for (int i = 0; i <t.length() ; i++) {
            if(s.isEmpty()&&i==0)continue;
            num^=t.charAt(i);
        }
        return (char) num;
    }
}