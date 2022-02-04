package String;

public class Conversion {
    public static void main(String[] args) {
        System.out.println(toLowerCase("al&phaBET"));
        System.out.println('A'+0);
    }
    public static String toLowerCase(String s) {

        char[] arr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                int a=(int)arr[i];
                a=a+32;
                char ch=(char)a;
                arr[i]=ch;
            }
        }
        String string=new String(arr);
        return string;
    }
}
