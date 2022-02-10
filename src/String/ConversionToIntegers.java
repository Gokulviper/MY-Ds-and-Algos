package String;


import java.util.ArrayList;
import java.util.Stack;

public class ConversionToIntegers {
    public static void main(String[] args) {
        System.out.println(BasicCalculator("3+2*2"));
    }

    public static String addBinary(String num1, String num2) {

        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while(i >= 0 || j >= 0 || carry > 0) {
            int val1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int val2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int add = val1 + val2 + carry;
            ans.insert(0, add % 10);
            carry = add / 10;
        }
        return ans.toString();

    }

    public static String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0"))
                return "0";
            StringBuilder ans = new StringBuilder("0");
            StringBuilder add = new StringBuilder();
            for(int i = num1.length() - 1; i >= 0; i--){
                int num = num1.charAt(i) - '0';
                StringBuilder mul = multiply(num, num2);//multiplying last number to all the number in the other string
                mul.append(add);//beacuse the adding last digit is nothing add to previous so the zero
                add.append('0'); //every time we add 0
                ans = sum(ans, mul);
            }
            return ans.toString();
        }
        public static StringBuilder multiply(int num, String str) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for(int i = str.length() - 1; i >= 0; i--) {
                int val = str.charAt(i) - '0';
                int pro = num * val + carry;
                sb.insert(0, pro % 10);
                carry = pro / 10;
            }
            if(carry > 0)
                sb.insert(0, carry);
            return sb;
        }
        public static StringBuilder sum(StringBuilder num1, StringBuilder num2) {
            StringBuilder ans = new StringBuilder();
            int carry = 0;
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            while(i >= 0 || j >= 0 || carry > 0) {
                int val1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
                int val2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
                int add = val1 + val2 + carry;
                ans.insert(0, add % 10);
                carry = add / 10;
            }
            return ans;
    }

    public static int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int i = 0;
        int n = s.length();

        // Discard all spaces from the beginning of the s string.
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (i < n && s.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // Traverse next digits of s and stop if it is not a digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) ||
                 (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
               // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
             return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }


            // Append current digit to the result.
            result = 10 * result + digit;
            i++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
    static  int normalConverter(String s){
      int sign=1; //identity and change +ve or -v numbers
        int res=0;
        int n=s.length();
        int i=0;
        while(i<n &&s.charAt(i)==' '){ //ignore leading spaces
            i+=1;
        }
        if(s.charAt(i)=='-'){  //change sign to - for change the whole number to -
            sign=-1;
            i++;
        }
        while (i<n && Character.isDigit(s.charAt(i))){
            int add=s.charAt(i)-'0';
            res=res*10+add;
            i++;
        }
        return sign*res;
    }
    public static int BasicCalculate2(String s) {
        //best approach
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < n; i++) {

            if (Character.isDigit(s.charAt(i))) {
                currentNumber = (currentNumber * 10) + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i)) || i == n - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = s.charAt(i);
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
    public static int BasicCalculator(String s) {
        //using stack not a best approach
        Stack<Integer> st=new Stack<>();
        char sign='+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(Character.isDigit(s.charAt(i))){
                int val=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    val=val*10+s.charAt(i)-'0';
                    i++;
                }
                i--;
                if(sign=='+'){
                    st.push(val);
                }else if(sign=='-'){
                    st.push(-val);
                }else if(sign=='*'){
                    st.push(st.pop()*val);
                }else if(sign=='/'){
                    st.push(st.pop()/val);
                }
            }else if(ch!=' '){
                sign=ch;
            }
        }
        int sum=0;
        while(st.size()!=0) sum+=st.pop();
        return sum;
    }


}
