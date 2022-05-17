package String;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] s) {
        if(s.length==0)return "";
        String prev=s[0];
        for(int i=1;i<s.length;i++){
            prev=c(prev,s[i]);
        }
        return prev;
    }
    private String c(String a,String b){
        int min=Math.min(a.length(),b.length());
        for(int i=0;i<min;i++){
        if(a.charAt(i)!=b.charAt(i)){
            return a.substring(0,i);
        }
        }
        return a.substring(0,min);
    }
}