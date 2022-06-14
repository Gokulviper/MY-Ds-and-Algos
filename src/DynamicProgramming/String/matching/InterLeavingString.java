package DynamicProgramming.String.matching;

import java.util.Arrays;

public class InterLeavingString {
    public static void main(String[] args) {
          String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
          int[][]dp=new int[s1.length()][s2.length()];
          for (int []r:dp) Arrays.fill(r,-1);

    }
   static boolean find(String s1,String s2,String s3,int i,int j ,int k){
        //if s1 is exhausted so balance s2 Strings are match with balance s3 string
        if (i==s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        //if s2 is exhausted so balance s1 Strings are match with balance s3 string
        if (j==s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }
       boolean ans=false;
        if ((s1.charAt(i)==s3.charAt(k)&&find(s1, s2, s3, i+1, j, k+1))||(s2.charAt(j)==s3.charAt(k)&&find(s1, s2, s3, i, j+1, k+1))){
          ans=true;

        }
        return ans;
    }
}
