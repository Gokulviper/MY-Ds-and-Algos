package String.SlidingWindow;

import java.util.Arrays;

public class sol {
    public static void main(String[] args) {
      foo(2345);
        int[] nums = {1,3,5,7,9};
        int n=nums.length;
        for (int i = 0; i <n ; i++) {
            if (nums[i]%7==0){
                nums[i]=nums[i+1]+1;
            }else if(nums[i]*2>12){
                nums[i-1]=nums[i]+nums[i-1];
                break;
            }else{
                    nums[i]=nums[i]-1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
  static   void foo(int  m){
  int n=m,i=1,j=1,k=0;
  while (n>0){
      i*=10;
      n/=10;
  }
  i/=10;
  while (i>0){
      j=(m/i);
      if (j%3==0){
          k=(k*10)+1;
      }else{
          k=k*10;
      }
      i/=10;
  }
      System.out.println(k);

    }
}
