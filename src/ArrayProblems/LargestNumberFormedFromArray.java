package ArrayProblems;

import java.util.Arrays;

class LargestNumberFormedFromArray {
    public static void main(String[] args) {

          String[]ans={"54","546","548","60"};
        System.out.println(printLargest(ans));
    }
   static String printLargest(String[]s) {
        //parse int not work for big test case like overflow occured
       for (int i = 0; i <s.length ; i++) {
           for (int j = i+1; j <s.length ; j++) {
               int s1=Integer.parseInt(s[i]+s[j]);
               int s2=Integer.parseInt(s[j]+s[i]);
               if (s1<s2){
                   swap(s,i,j);
               }
           } }
       String ans="";
       for (String ch:s)  ans+=ch;
       return ans;
    }
    static void swap(String[]nums,int a,int b){
        String t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    String printLargest1(String[] arr) {
        Arrays.sort(arr, (s1, s2)->
        {return (s2+s1).compareTo(s1+s2);});
        String s="";
        for(String x:arr) s+=x;
        return s;
    }
}