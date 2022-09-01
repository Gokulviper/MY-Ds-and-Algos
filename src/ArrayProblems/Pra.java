package ArrayProblems;

import com.sun.jdi.event.StepEvent;

import java.util.*;

public class Pra {
    public static void main(String[] args) {
     int[]nums={1 ,2 ,2, 5 ,6, 9, 5, 2};
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

    private static void cal(String s) {
      int i=0,j=s.length()-1;
      String ans="";
      while (i<s.length()){

      }
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
