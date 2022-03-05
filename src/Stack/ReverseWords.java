package Stack;

public class ReverseWords {
    public static void main(String[] args) {
       String s = "  hello world  ";
        System.out.println(reverseWords(s));
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
}
