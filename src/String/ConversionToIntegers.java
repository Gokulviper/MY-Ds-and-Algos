package String;


public class ConversionToIntegers {
    public static void main(String[] args) {
        System.out.println(multiply("6","2"));

    }
    public static String multiply(String s1,String s2){
        if(s1=="0"||s2=="0")return "0";
        int num1=getInte(s1);
        int num2=getInte(s2);
        int ans=num1*num2;
      String answer="";
      while (ans>0){
          answer=ans%10+answer;
          ans/=10;
      }
        return answer;
    }

    private static int getInte(String s) {
        int num=0;
        int j=s.length()-1;
      //  num=s.charAt(j--)-'0';
        while (j>=0){
            num=num*10+s.charAt(j)-'0';
            j--;
        }
        return num;
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
    public static int calculate(String s) {
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

}
