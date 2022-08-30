package ArrayProblems;

import com.sun.jdi.event.StepEvent;

import java.util.*;

public class Pra {
    public static void main(String[] args) {
     int[]nums={1 ,2 ,2, 5 ,6, 9, 5, 2};
     alternateDub(nums);
        System.out.println(Arrays.toString(nums));
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
       Map<Character,Character> map=new HashMap<>();
       int j=97+25;
        for (int i = 97; i <=97+25 ; i++) {
             map.put((char)i,(char)j--);
        }
        j=65+25;
        for (int i = 65; i <=65+25 ; i++) {
            map.put((char)i,(char)j--);
        }
        String ans="";
       for(char ch:s.toCharArray()){
           ans+=map.get(ch);
       }
        System.out.println(ans);
    }

    private static int ma(int a, int b, char sign) {
        if(sign=='+')return a+b;
        if (sign=='-')return a-b;
        if (sign=='*')return a*b;
        return a/b;

    }

    private static void find(int[] nums) {
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
    }

    private static void gcg(int n) {
       boolean[]primes=new boolean[n+1];
        for (int i = 2; i <=n ; i++) {
            if (!primes[i]){
                for (int j = i*i; j <=n ; j+=i) {
                    primes[j]=true;
                }
            }
        }
        for (int i = 2; i <=n ; i++) {
            if (!primes[i]) System.out.println(i);
        }

    }
}
