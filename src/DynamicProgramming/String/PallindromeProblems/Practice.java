package DynamicProgramming.String.PallindromeProblems;

//import static sun.net.ftp.FtpReplyCode.find;

//import static sun.net.ftp.FtpReplyCode.find;

import ArrayProblems.Sorting.GeneralAlgorithms.P;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
 int[]nums={5,7,2,3,9,0,0};
  fun1(nums,15);

    }

    private static void funstr(String s) {
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+1; j <=s.length() ; j++) {
                System.out.println(s.substring(i,j));
            }
        }
    }
    private static void fun1(int[] nums,int target) {


            int ans=-1;
        for (int i = 0; i <nums.length ; i++) {
            int left_sum=0,right_sum=0;
            int partition=0;
            boolean first_half=true;
            for (int j = 0; j <nums.length ; j++) {
                if (i==j){
                    partition=nums[i];
                    first_half=false;
                }else if(first_half){
                    left_sum+=nums[j];
                }else if (!first_half){
                    right_sum+=nums[j];
                }

            }
            if (right_sum==left_sum){
                ans=partition;
            }
        }
        System.out.println(ans);
        }


    private static void findstring(String s) {

    }

    static void find(int n) {


    }
}
