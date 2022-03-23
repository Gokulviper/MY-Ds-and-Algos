package String;

public class Encode {
    public static void main(String[] args) {
        String s="abbacacccc"; //a1b2a1c1
        System.out.println(Encodes(s));
    }
    private static String Encodes(String s){

        StringBuilder sb=new StringBuilder();
        char temp=' ';
        int count=1;int i=1;
        for (;i<s.length();i++){
            if (s.charAt(i-1)!=s.charAt(i)){
                sb.append(s.charAt(i-1));
                sb.append(count);
                count=1;
            }else{
                count++;
            }
        }
        sb.append(s.charAt(i-1));
        sb.append(count)      ;
    return sb.toString();
    }
}
