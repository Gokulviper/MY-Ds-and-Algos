package DynamicProgramming.String.PallindromeProblems;

//import static sun.net.ftp.FtpReplyCode.find;

//import static sun.net.ftp.FtpReplyCode.find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
 int[]nums={2,3,0,0,2,3,5,6,23,56,77,211};
  fun1(nums,4);
        System.out.println(Arrays.toString(nums));
    }

    private static void funstr(String s) {
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+1; j <=s.length() ; j++) {
                System.out.println(s.substring(i,j));
            }
        }
   
    }

    private static void fun1(int[] nums,int target) {
         int i=0;
        for (int j = 0; j <nums.length ; j++) {
            if (nums[i]%2==0&&nums[j]%2!=0){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                i++;
            }else if(nums[i]%2!=0){
                i++;
            }

        }
        }


    private static void findstring(String s) {

    }

    static void find(int n) {
        int outerSpace=n-1;
        int starts=1;
        for (int i = 0; i <=n; i++) {
            if(i<n/2) {
                for (int j = 0; j < outerSpace; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < starts; j++) {
                    System.out.print("* ");
                }
                outerSpace--;
                starts++;

            }else{
                for (int j = 0; j <outerSpace ; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <starts ; j++) {
                    System.out.print("* ");
                }
                outerSpace++;
                starts--;
            }
            System.out.println();
        }
    }
}
