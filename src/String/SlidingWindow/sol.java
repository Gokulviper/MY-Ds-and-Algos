package String.SlidingWindow;

import java.util.*;

public class sol {
    public static void main(String[] args) {

        System.out.println(foo(23,4)); ;
        int[] nums = {1,3,5,7,9,6,6};

        int n=nums.length;
        for (int i = 0; i <n ; i++) {
            if (nums[i]/3==0){
                nums[i]=nums[i+1]+1;
            }else if(nums[i]*2>15){
                nums[i-1]=nums[i]+nums[i-1];
                break;
            }else{
                    nums[i]=nums[i]-1;
            }
        }
     //   System.out.println(Arrays.toString(nums));
    }
  static   int foo(int  a,int b){
   if(b==0){
       return a;
   }
   if (a%2==0){
     foo(a/2,b/2);
   }
   return foo(a+1,b-1);
      }

}
