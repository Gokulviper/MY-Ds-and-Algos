package String;

public class DecodeString {
    public static void main(String[] args) {
        String s="3[a2[c]]";
        System.out.println(decodeString(s));

    }

   static int i=0; //we use recursion so maintain the the string length
    public static String decodeString(String s) {
        StringBuffer result = new StringBuffer();

        while(i<s.length() && s.charAt(i)!=']')//the question type is so inner brackets so in  recursion out from the one brackets us use the ] bracket
        {
            if(Character.isDigit(s.charAt(i)))      //finding the digit how many time we print
            {
                int k=0;                                                //inner variable maintain how many times print the innerStrings
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                {
                    k=k*10+s.charAt(i++)-'0';
                }
                i++;      //skip bracket
                String r = decodeString(s);  //recursion call for inner numbers and digits
                while(k-->0)
                {
                    result.append(r);
                }
                i++;        //skip bracket
            }
            else
            {
                result.append(s.charAt(i++));  //there is no inner digits just this print the characters
            }
        }
        return result.toString();

    }





}
