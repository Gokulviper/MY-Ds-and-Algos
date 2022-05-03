package DynamicProgramming;

import java.awt.*;
import java.awt.print.PrinterGraphics;
import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[]jumpLengths={10,20,40,50,10};
        System.out.println(findShortTestPathKJumps(jumpLengths,jumpLengths.length-1,4));

    }
    private static int findShortTestPathKJumps(int[] jumps,int i,int k) {
     if (i==0)return 0;
     int minStpes=Integer.MAX_VALUE;

  //   while (i>0) {
         for (int j = 1; j <= k; j++) {
             if (i - j >= 0) {
                 int ju = findShortTestPathKJumps(jumps, i - j, k) + Math.abs(jumps[i] - jumps[i - j]);
                 minStpes = Math.min(minStpes, ju);
             }
         }
    //     i--;

 //    }
        return minStpes;

    }
    private static int spaceOptimized(int[] jumps) {
        int  prev=0,s_prev=0;
        for (int i = 1; i < jumps.length ; i++) {
            int left=prev+Math.abs(jumps[i-1]-jumps[i]);
            int right= Integer.MAX_VALUE;
            if (i>1){
                right=s_prev+Math.abs(jumps[i-2]-jumps[i]);
            }
          int   curr=Math.min(left,right);

            s_prev=prev;
            prev=curr;
        }
        return prev;
    }

    private static int BottomUp(int[] jumps) {
        int[]dp=new int[jumps.length];
        dp[0]=0;
        for (int i = 1; i <jumps.length ; i++) {
            int left=dp[i-1]+Math.abs(jumps[i]-jumps[i-1]);
            int right=Integer.MAX_VALUE;
            if (i>1){
                right=dp[i-2]+Math.abs(jumps[i]-jumps[i-2]);
            }
            dp[i]=Math.min(left,right);
        }
        return dp[jumps.length-1];
    }

    private static int topDown(int[] jumps, int i, int[] dp) {
        if (dp[i]==0){
            if (i==0)return 0;
            int right=Integer.MAX_VALUE;
            int left=topDown(jumps,i-1,dp)+(Math.abs(jumps[i]-jumps[i-1]));
            if (i>1)right=topDown(jumps,i-2,dp)+Math.abs(jumps[i]-jumps[i-2]);
            return Math.min(left,right);
        }
        return dp[i];
    }

    private static int findShortTestPath(int[] jumps, int i) {
        if (i==0)return 0;
        int left=findShortTestPath(jumps,i-1)+Math.abs(jumps[i]-jumps[i-1]);
        int right=Integer.MAX_VALUE;
        if (i>1){right=findShortTestPath(jumps,i-2)+Math.abs(jumps[i]-jumps[i-2]);}
        return Math.min(left,right);
    }

}
