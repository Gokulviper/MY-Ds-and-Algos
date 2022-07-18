package BitManipulations.Problems;

import java.util.Arrays;

class MaxProductOfWordlengths {
    public static void main(String[] args) {
      String[]  ords = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(ords));
    }
    public static int maxProduct(String[] words) {
        int ans=0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j){
                    if(compare(words[i],words[j])){
                        ans=Math.max(ans,words[i].length()*words[j].length());
                    }
                }
            }
        }
        return ans;
    }
    static  boolean  compare(String s1,String s2){
        char[]ch=s1.toCharArray();
        char[]ch1=s2.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch1);
        s1=String.valueOf(ch);
        s2=String.valueOf(ch1);
        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            if(s1.charAt(i)==s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}