package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class PlusOne {
    public static void main(String[] args) {
        int []nums={9,8,7,6,5,4,3,2,1,0};
        int[]ans=plusOne(nums);
        System.out.println(Arrays.toString(ans));

    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++; return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }
    public static int[] plusOne1(int[] digits) {
    int value=0;
        for(int num:digits){
            value=(value*10)+num;
        }
        ArrayList<Integer>list=new ArrayList<>();
        value++;
      while(value!=0){
          list.add(value%10);
          value/=10;
      }
        int[]ans=new int[list.size()];
      int i=0;
        for(int j=ans.length-1;j>=0;j--){
            ans[i++]=list.get(j);
       }

     return ans;
        
    }
}