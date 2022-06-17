package String;

import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                else if (sign == '+') {
                    stack.push(num);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public int calculate1(String s) {
      if(s==null||s.isEmpty())return 0;
      int num=0,lastNum=0,ans=0;
      char sign='+';
      for(int i=0;i<s.length();i++){
          char current=s.charAt(i);
          if(Character.isDigit(current)){
              num=(num*10)+(current-'0');
          }
          if(!Character.isDigit(current)&&!Character.isWhitespace(current)||i==s.length()-1){
              if(sign=='+'||sign=='-'){
                  ans+=lastNum;
                  lastNum=sign=='+'?num:-num;
              } else if (sign == '*') {

                  lastNum=lastNum*num;

              } else if (sign == '/') {

                  lastNum=lastNum/num;
              }
              sign=current;
              num=0;
          }
      }
      ans+=lastNum;
return ans;
    }
}
