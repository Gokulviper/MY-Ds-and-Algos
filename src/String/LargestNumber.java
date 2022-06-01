package String;

import java.util.Arrays;

class LargestNumber {
    public static void main(String[] args) {

    }
    public String largestNumber(int[] s) {
        if(s==null||s.length==0)return null;
        String[]nums=new String[s.length];
        for(int i=0;i<s.length;i++){
            nums[i]=String.valueOf(s[i]);
        }
        Arrays.sort(nums,(a, b)->{return (b+a).compareTo(a+b);});
        String ans="";
        for(String num:nums){
            ans+=num;
        }
        return ans.charAt(0)=='0'?"0":ans;
    }
}