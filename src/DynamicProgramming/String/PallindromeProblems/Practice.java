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
 int[]nums={3,4,5,2,5,7,989,7766};
  String[] strs = {"anwarrr","anwarring","anwa"};
     find(4);

    }

    private static void stringrr(String[] strs) {
        String s=strs[0];
        for (int i = 1; i <strs.length ; i++) {
            s=str(s,strs[i]);
        }
        System.out.println(s);
    }

    private static String str(String s1, String s2) {
        int start=0;
      int end=0;
      for (;end<Math.min(s1.length(),s2.length());end++){
          if (s1.charAt(end)!=s2.charAt(end)){
              break;
          }
      }
      return s1.substring(start,end);
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

    private static void funstr(String s,int i) {

    }
      int f(String s,String t,int i,int j){
        if(i<0||j<0)return 0;
          if (s.charAt(i)==t.charAt(j)){
              return 1+f(s,t,i-1,j-1);
          }
       return Math.max(f(s,t,i-1,j),f(s,t,i,j-1));

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
      List<Integer>ans=new ArrayList<>();
      int i=0;
      int prev=-1;
        for (int j = nums.length-1; j >=0 ; j--) {
            if (lis[j]==max&&(prev==-1||prev>nums[j])){
                ans.add(nums[j]);
                max-=1;
                prev=nums[j];
            }
        }
        System.out.println(ans);

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
       int number=1;
        for (int i = 0; i < n; i++) {
            if (number!=1){
                number+=4;
            }
            if (i%2==0) {

                for (int j = 0; j < n; j++) {
                    System.out.print(number+++" ");
                }
            }else{
                for (int j = 0; j < n; j++) {
                    System.out.print(--number+" ");
                }
            }
            System.out.println();
        }
    }
}
