package DynamicProgramming.String.PallindromeProblems;

//import static sun.net.ftp.FtpReplyCode.find;

//import static sun.net.ftp.FtpReplyCode.find;

import ArrayProblems.Sorting.GeneralAlgorithms.P;

import javax.swing.*;
import java.util.*;
class Node{
    int num;
    int freq;
    Node(int num,int freq){
        this.num=num;
        this.freq=freq;
    }
}
public class Practice {
    public static void main(String[] args) {
 int[]nums={5,5,2,4,5,2,67,7,3,2,67,2255,55,6,3,2};

      find(5);

    }

    private static void gcd(int a, int b) {
        int n=Math.max(a,b);
        int gcd=1;
       while (true){
           if (n%a==0&&n%b==0){
               System.out.println(n);
               break;
           }
           n++;
       }
        }
    private static int matrix(int[][] mat) {
        return f(mat,mat.length-1,mat[0].length-1);
    }

    private static int f(int[][] mat, int row, int col) {
        if (row<0||col<0)return 0;
        return mat[row][col]+Math.max(f(mat,row-1,col),f(mat,row,col-1));

    }

    private static void funstr(String s) {
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+1; j <=s.length() ; j++) {
                System.out.println(s.substring(i,j));
            }
        }
    }
    private static void fun1(int[] nums,int target) {
      int[]lis=new int[nums.length];
      Arrays.fill(lis,1);
      int max=0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if (nums[j]<nums[i]&lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                }
            }
            max=Math.max(max,lis[i]);
        }
        int[]ans=new int[nums.length];


        }


    private static void findstring(String s) {
      Set<Character>set=new HashSet<>();
      String ans="";
      Map<Character,Integer>map=new HashMap<>();
      Map<Character,Character>chars=new HashMap<>();
      for(char ch:s.toCharArray()){map.put(ch,map.getOrDefault(ch,0)+1);
      }
        for (int i = 0; i <s.length() ; i++) {
            char ch=' ';
            if (set.contains(s.charAt(i))){
                if (chars.containsKey(s.charAt(i))) {
                    int num=(int)chars.get(s.charAt(i));
                    num++;
                    ch=(char) num;
                    ans+=ch;
                }else {
                    int num = (int) s.charAt(i);
                    num++;
                    //again.put(s.charAt(i),(char)num);
                    ch = (char) num;
                    ans += ch;
                }
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if (map.get(s.charAt(i))>0){
                    chars.put(s.charAt(i),ch);
                }
                set.add(ch);
            }else{
                ans+=s.charAt(i);
                set.add(s.charAt(i));
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
            }
        }
        System.out.println(ans);
        }


    static void find(int n) {

    }
}
