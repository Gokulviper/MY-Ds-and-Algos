package String.Recursion;

import java.util.Stack;

class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString1("2[abc]3[cd]ef"));
    }
  int i=0; 
public String decodeString(String s) {

    StringBuffer result = new StringBuffer();

    while (i < s.length() && s.charAt(i) != ']')//the question type is so inner brackets so in  recursion out from the one brackets us use the ] bracket
    {
        if (Character.isDigit(s.charAt(i)))      //finding the digit how many time we print
        {
            int k = 0;                                                //inner variable maintain how many times print the innerStrings
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                k = k * 10 + s.charAt(i++) - '0';
            }
            i++;      //skip bracket
            String r = decodeString(s);  //recursion call for inner numbers and digits
            while (k-- > 0) {
                result.append(r);
            }
            i++;        //skip bracket
        } else {
            result.append(s.charAt(i++));  //there is no inner digits just this print the characters
        }
    }

    return result.toString();
}

    public static String decodeString1(String s) {
    Stack<Integer>counts=new Stack<>();
    Stack<String> result=new Stack<>();
    String res="";int i=0;
    while (i<s.length()){
        if(Character.isDigit(s.charAt(i))){  //this handle diggits
            int count=0;
            while (Character.isDigit(s.charAt(i))){
                count=count*10+(s.charAt(i))-'0';
                i++;
            }
            counts.push(count);
        }else if(s.charAt(i)=='['){
            result.push(res);
            res="";
            i++;

        }else if(s.charAt(i)==']'){
            StringBuilder sb=new StringBuilder(result.pop());
            int count=counts.pop();
            for (int j=0;j<count;j++){
                    sb.append(res);
            }
            res=sb.toString();
            i++;
        }else {
            res+=s.charAt(i);
            i++;            //this handle only characters
        }
    }
    return res;

    }


}