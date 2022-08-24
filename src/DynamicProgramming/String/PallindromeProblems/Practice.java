package DynamicProgramming.String.PallindromeProblems;

//import static sun.net.ftp.FtpReplyCode.find;

//import static sun.net.ftp.FtpReplyCode.find;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
   funstr("abbbbbbcccsdyh");
    }

    private static void funstr(String s) {
       char ch=s.charAt(0);
       int num=0;
       String ans="";
       int i=0;
       while (i<s.length()){
           ch=s.charAt(i++);
           num=1;
           while (i<s.length()&&ch==s.charAt(i)){
               num++;
               i++;
           }
           ans+=ch+""+num;

       }
        System.out.println(ans);
   
    }

    private static void fun1(int[] nums,int target) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i; j <=nums.length ; j++) {
                for (int k = i; k <j ; k++) {
                    System.out.print(nums[k]);
                }
                System.out.println();
            }

        }
        }


    private static void findstring(String s) {

    }

    static void find(int n) {
        
    }
}
