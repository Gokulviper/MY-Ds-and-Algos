package String;

public class EasyProblems {
    public static void main(String[] args) {

        System.out.println(reverseWords( "Let's take LeetCode contest"));
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) carry += num1.charAt(i) - '0';
            if (j >= 0) carry += num2.charAt(j) - '0';
            sb.append(carry % 10);
            carry /= 10;
            i--;
            j--;
        }
        StringBuilder ans=sb.reverse();
        return ans.toString();

    }
    public  static String multiplyStrings(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];

        int i = len2-1;
        int pf = 0;  //power factor
        while(i >= 0){
            int ival = num2.charAt(i) - '0';
            i--;

            int j = len1-1;
            int k = result.length-1-pf;
            int carry = 0;

            while(j >= 0 || carry != 0){
                int jval = j>=0 ? num1.charAt(j) - '0' : 0;
                j--;

                int product = ival*jval+carry+result[k];

                result[k] = product%10;
                carry = product/10;
                k--;
            }

            pf++;
        }

        //managment of leading zero using general method
        String str = "";
        boolean flag = false;
        for (int val : result) {
            if(val == 0 && flag == false){
                //leading zero
                continue;
            }else{
                flag  = true;
                str += val;
            }
        }
        return str;
    }
    public static String reverseWords(String s) {
        char space = ' ';
        String temp = "";
        String ans = "";
        for (int i = 0; i < s.length(); i++) {

            temp += s.charAt(i);
            if (s.charAt(i) == ' ') {
                ans += reverse(temp);
                if(i!=s.length()-1)
                ans += ' ';
                temp="";
            }

            if (i == s.length() - 1 ) {
                if(s.charAt(i)==' '){
                ans += ' ';

            }
                ans+=reverse(temp);
                ans+=' ';
            }
        }
        return ans;
    }
    public static String reverse(String s){
        char ch;
        String reversed="";
        for(int i=0;i<s.length()-1;i++){
            ch=s.charAt(i);
            reversed=ch+reversed;
        }
        return reversed;
    }
}
