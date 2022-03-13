package Stack;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
       String s = "  hello world  ";
        System.out.println(reverseWords1(s));
    }

    public static String reverseWords(String s) {
     StringBuilder sb=new StringBuilder();
     String temp="";
     for (int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         if (Character.isWhitespace(ch)&&!temp.isEmpty()){
             sb.insert(0,temp);temp="";
             if (i!=s.length()-1){
                 sb.insert(0," ");
             }
         }else if(!Character.isWhitespace(ch)){
             temp+=ch;
         }
     }
     sb.insert(0,temp);

     if (Character.isWhitespace(sb.charAt(0))){int i=0;
         for (;i<sb.length();i++){
             if (Character.isWhitespace(sb.charAt(i))){

             }else{
break;
                }
             }   sb.replace(0,i,"");
         }


     return  sb.toString();
    }
    public static String reverseWords1(String s) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(Character.isWhitespace(s.charAt(i))){i++;}


        Stack<String> stack=new Stack();
        String temp="";
        for(;i<s.length();i++){
            if(Character.isWhitespace(s.charAt(i))){
                if(!temp.isEmpty()) {
                    stack.push(temp);
                    stack.push(" ");

                    temp = "";
                }
                i++;
            }else
            temp+=s.charAt(i);

        }
        stack.push(temp);
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();

    }


}
