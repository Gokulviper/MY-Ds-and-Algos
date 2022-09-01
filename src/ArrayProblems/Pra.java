package ArrayProblems;

import com.sun.jdi.event.StepEvent;

import javax.sound.midi.MidiFileFormat;
import java.util.*;

public class Pra {
    public static void main(String[] args) {
    gcg(6);
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

    private static void cal(String s1,String s2) {
        StringBuilder sb=new StringBuilder();
     int i=s1.length()-1,j=s2.length()-1,carry=0;
     while (i>=0||j>=0||carry>0){
         int val1=i>=0?s1.charAt(i--)-'0':0;
         int val2=j>=0?s2.charAt(j--)-'0':0;
         int sum=val1+val2+carry;
         sb.insert(0,sum%10);
         carry=sum/10;

     }
        System.out.println(sb);
    }

    private static int ma(int a, int b, char sign) {
        if(sign=='+')return a+b;
        if (sign=='-')return a-b;
        if (sign=='*')return a*b;
        return a/b;

    }

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
        int space=0;
        for (int i = 0; i <n ; i++) {
            int j = 0;
            for (; j <space ; j++) {
                System.out.print(" ");
            }
           while (j++<n) System.out.print("*");
space++;
            System.out.println();
        }

    }
}
