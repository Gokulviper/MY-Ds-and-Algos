package Treee.problems.BinaryTreeProblems;

//import static jdk.nashorn.internal.objects.Global.print;

import javax.swing.text.AttributeSet;
import java.util.*;

public class Pattern {
    public static void main(String[] args) {
        int[]nums={4,4,52,5,7,9,8,22,35};
    //    System.out.println(29/3);
         String s="A man, in the boat says : I see 1-2-3 in the sky";
        System.out.println(find(s));
   //  shortestPath(nums);
      //  System.out.println(Arrays.toString(nums));
        //System.out.println(find("374291--*+-"));
    }

    private static void shortestPath(int[]nums) {
       PriorityQueue<Integer>oddPq=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer>evenPq=new PriorityQueue<>((a,b)->a-b);
        for(int num:nums){
            if (num%2==0)evenPq.add(num);
            else oddPq.add(num);
        }
        for (int i = 0; i <nums.length ; i++) {
            if(!evenPq.isEmpty())
            nums[i]=evenPq.poll();
            else nums[i]=oddPq.poll();
        }


    }

    private static String find(String s) {
        int j=s.length()-1;
      String ans="";
        for (int i = 0; i <s.length() ; i++) {


          if (Character.isLetter(s.charAt(i))){
              while (j>0&&!Character.isLetter(s.charAt(j))){
                  j--;
              };
              ans+=s.charAt(j);
              j--;
          }else{
              ans+=s.charAt(i);
          }
      }
        return ans;
    }

    private static int add(int num1, Integer num2, Character sign) {
        if(sign=='+')return num1+num2;
        if (sign=='-')return num1-num2;
        if(sign=='*')return num1*num2;
       return num1/num2;
    }

    static void print(int n) {

            }

        }
      








