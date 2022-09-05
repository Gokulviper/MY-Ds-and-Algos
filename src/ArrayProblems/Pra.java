package ArrayProblems;

import com.sun.jdi.event.StepEvent;

import javax.sound.midi.MidiFileFormat;
import java.util.*;

public class Pra {
   static public  void main(String[] args) {
  int[]nums={1,2,3,3,5,6,7,78,8,6};
  gcg(5);
  integerTowowords(23);
        integerTowowords(2345);
        integerTowowords(4657);
        integerTowowords(325365);
        integerTowowords(1);
        integerTowowords(890);
        integerTowowords(9879);
        integerTowowords(435);
    }

    private static void integerTowowords(long l) {
        Map<Integer,String>map=new HashMap<>();
        map.put(1,"one");  map.put(2,"two");  map.put(3,"three");  map.put(4,"four");  map.put(5,"five");
        map.put(6,"six");  map.put(7,"seven");  map.put(8,"eight");  map.put(9,"nine");  map.put(10,"ten");
        map.put(11,"elven");  map.put(12,"twelve");  map.put(13,"thirteen");  map.put(14,"fourteen");  map.put(15,"fifteen");
        map.put(16,"sixteen");  map.put(17,"seventeen");  map.put(18,"eighteen");  map.put(19,"nineteen");  map.put(20,"twenty");
        map.put(30,"thirty");  map.put(40,"fourty");  map.put(50,"fifty");  map.put(60,"sixty");  map.put(70,"seventy");
        map.put(80,"eighty");  map.put(90,"ninety");  map.put(100,"hundred");  map.put(1000,"thousand");  map.put(100000,"lakh");
        map.put(10000000,"crore");
       int n=(int)l;
       String ans="";
       if (n>=10000000){
           int c=n/10000000;
           if (c>=20)ans+=map.get(c-(c%10))+map.get(c%10)+"crore";
           else ans+=map.get(c)+"crore";;
           n%=10000000;
       }
        if (n>=100000){
            int c=n/100000;
            if (c>=20)ans+=map.get(c-(c%10))+map.get(c%10)+"lakh";
            else ans+=map.get(c)+"lakh";;
            n%=100000;
        }
        if (n>=1000){
            int c=n/1000;
            if (c>=20)ans+=map.get(c-(c%10))+map.get(c%10)+"thousand";
            else ans+=map.get(c)+"thousand";;
            n%=1000;
        }
        if (n>=100){
            int c=n/100;
          ans+=map.get(c-(c%10))+map.get(c%10)+"hundred";
            n%=100;
        }
        if (n>=20&&(int)l>=100){
            ans+="and"+map.get(n-(n%10))+map.get(n%10);
        }else if(n>0&&(int)l>=100){
            ans+="and"+map.get(n);
        }else if((int)l<100){
            if((int)l>=20)ans+=map.get(n-(n%10))+map.get(n%10);
            else ans+=map.get(n);
        }
        System.out.println(ans);
    }


    private static void alternateDub(int[] nums) {
       int j=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]%2!=0&&nums[j]%2==0){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                j++;
            }else if(nums[j]%2!=0){
                j++;
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
        System.out.println(1);
        String s="1";
        int i=1;
        while (i<n){
            int count=1;
            String new_string="";
            char ch=s.charAt(0);
            for (int j = 1; j <s.length() ; j++) {
                if (s.charAt(j-1)!=s.charAt(j)){
                    System.out.print(count+""+ch);
                    new_string+=""+count+""+ch;
                    count=1;
                    ch=s.charAt(j);
                }else{
                    count+=1;
                }
            }
            System.out.println(count+""+ch);
            new_string+=""+count+""+ch;
            s=new_string;
            i++;
        }

    }
}
