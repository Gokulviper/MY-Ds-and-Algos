package String.SlidingWindow;

public class LongestVowelSubString {
    public static void main(String[] args) {
        String s="abclehjsgfi";
        System.out.println(s.substring(1,4));
        System.out.println(longest(s));
    }


    private static String longest(String s) {
        String ans="";
        int start=-1,end=-1;
        for (int i = 0; i <s.length() ; i++) {
            if ((s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')){
                if (start==-1){
                    start=i;
                }else{
                    end=i;
                }
            }
            if(start!=-1&&end!=-1){
                String temp=s.substring(start+1,end);
                if (temp.length()>ans.length()){
                    ans=temp;

                }
                start=end;
                end=-1;
            }
        }

    return ans;}
}
