package String;

import java.util.Locale;

class ValidPallindrome {
    public static void main(String[] args) {
        String s = "OP";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int start=0,end=s.length()-1;
        while (start<end){
            while (start<end&&!Character.isLetter(s.charAt(start))){
                start++;
            }
            while (start<end&&!Character.isLetter(s.charAt(end))){
                end--;
            }
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
        }
        return true;

    }

    public static boolean isPalindrome1(String s) {
        String main="";
      String s1=  s.toLowerCase();
        for(char ch:s1.toCharArray()){
            if(Character.isLetter(ch)){
            main+=ch;
            }
        }

        String reverse=rev(main);
      if (main.equals(reverse)){
          return true;
      }
      return false;
        
    }
    private static String rev(String s){
        String sb="";
     for(int i=s.length()-1;i>=0;i--){
         sb+=s.charAt(i);
     }
        return sb;
    }
}