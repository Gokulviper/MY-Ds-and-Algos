package ArrayProblems;

import com.sun.jdi.event.StepEvent;

import javax.sound.midi.MidiFileFormat;
import java.util.*;

public class Pra {
    public static void main(String[] args) {
  String s="ahfhieksgsjou";
  cal(s);
    }

    private static void alternateDub(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
                nums[i]=0;
            }else{
                set.add(nums[i]);
            }
        }
    }

    private static void cal(String s) {
        Set<Character>set=new HashSet<>();
set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        String vowel="";
        for(char ch:s.toCharArray()){
            if (set.contains(ch)){
                vowel+=ch;
            } }
        String ans="";
        int j=vowel.length()-1;
        for (int i = 0; i <s.length() ; i++) {
            if (set.contains(s.charAt(i))){
                ans+=vowel.charAt(j--);
            }else{
                ans+=s.charAt(i);
            }
        }
        System.out.println(ans);
    }

    private static int ma(int a, int b, char sign) {
        if(sign=='+')return a+b;
        if (sign=='-')return a-b;
        if (sign=='*')return a*b;
        return a/b;

    }
/*
  int leftSum=0,rightSum=0;
        int i=0,j=nums.length-1;
        for ( i = 0,j=nums.length-1; i <j ; i++,j--) {
         leftSum+=nums[i];
         rightSum+=nums[j];
         while (i<j&&leftSum<rightSum){
             i++;
             leftSum+=nums[i];
         }
         while(i<j&&leftSum>rightSum){
             j--;
             rightSum+=nums[j];
         }

        }
        if (leftSum==rightSum&&i==j) System.out.println(nums[j]);
        else System.out.println(-1);
 */
    private static void find(int[] nums) {
      int left_sum=0,right_sum=0;
      int i=0,j=nums.length-1;
       for(i=0,j=nums.length-1;i<j;i++,j--){
           left_sum+=nums[i];
           right_sum+=nums[j];
           while (i<j&&left_sum<right_sum){
               left_sum+=nums[++i];
           }
           while (i<j&&left_sum>right_sum){
               right_sum+=nums[--j];
           }
       }
       if (left_sum==right_sum&&i==j) System.out.println(nums[j]);
    }

    private static void gcg(int n) {
     int size=2*n;
        for (int i = 0; i <=size ; i++) {
            for (int j = 0; j <=size ; j++) {
                int val1=Math.abs(i-n)+1;
                int val2=Math.abs(j-n)+1;
                System.out.print(Math.max(val1,val2)+" ");
            }
            System.out.println();
        }

    }
}
