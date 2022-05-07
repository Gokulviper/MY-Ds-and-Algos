package DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
          int[][]ninjaWork={{1,2,4},{5,2,8},{3,4,7}};
          ///training one you dont practice  same work on next day
        //retunn maximum points you get
        int[][]dp=new int[ninjaWork.length][ninjaWork.length];
        for (int[] num:dp)
        {
            Arrays.fill(num,-1);
        }
        System.out.println(tabulation(ninjaWork));
    }

    private static boolean tabulation(int[][] ninjaWork) {
        return false;
    }

    private static int memoriazation(int[][] points, int last, int day,int[][]dp) {
        if (day==0){
            int max=0;
            for (int i = 0; i <points[0].length ; i++) {
                if (i!=last){
                    max=Math.max(max,points[0][i]);
                }
            }
            return max;
        }
        if (dp[day][last]!=-1)return dp[day][last];
        int max=0;
        for (int i = 0; i <points[0].length ; i++) {
            if (i!=last){
                int point=points[day][i]+memoriazation(points,i,day-1,dp);
                max=Math.max(max,point);
            }
        }
        return dp[day][last]=max;
    }

    private static int maxPoints(int[][] points, int last, int day) {
        if (day==0){
            int max=0;
            for (int i = 0; i <points[0].length ; i++) {
                if (i!=last){
                    max=Math.max(max,points[0][i]);
                }
            }
            return max;
        }
        int max=0;
        for (int i = 0; i <points[0].length ; i++) {
            if (i!=last){
                int point=points[day][i]+maxPoints(points,i,day-1);
                max=Math.max(max,point);
            }
        }
        return max;
    }
}
