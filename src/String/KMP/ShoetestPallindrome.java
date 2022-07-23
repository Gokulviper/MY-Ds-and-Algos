package String.KMP;

class ShoetestPallindrome {
    public static void main(String[] args) {
            String s="abcd";
        System.out.println(shortestPalindrome(s));

    }
    public static String shortestPalindrome(String s) {
        if(s.length()==0) return s;
        int len=LPS(s + "#" + new StringBuilder(s).reverse().toString());
        
        return new StringBuilder(s.substring(len)).reverse().toString()+s;
    }
    
    public static int LPS(String s){
        int lps[]=new int[s.length()];
        
        int len=0;
        int i=1;
        
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i++]=len;
            }
            else{
                if(len>0) len=lps[len-1];
                else i++;
            }
        }
        return lps[lps.length-1];
    }
}