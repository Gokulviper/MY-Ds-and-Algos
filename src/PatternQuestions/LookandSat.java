package PatternQuestions;

public class LookandSat {
    public static void main(String[] args) {
    lns1(5);
    }

    private static void lns1(int n) {
        System.out.println(1);
        int i=1;
        String s="1";
        while (i<n){
            String newS="";
            char ch=s.charAt(0);
            int count=1;
            for (int j = 1; j <s.length() ; j++) {
                if (s.charAt(j)!=s.charAt(j-1)){
                    System.out.print(count+""+ch);
                    newS+=""+count+""+ch;
                    count=1;
                    ch=s.charAt(j);
                }else{
                    count++;
                }
            }
            System.out.println(count+""+ch);
            newS+=""+count+""+ch;
            s=newS;
            i++;
        }
    }

    private static void lns(int n) {
        System.out.println(1);
        int i=1;
        String s="1";
        while (i<n){
            String newString="";
            int count=1;
            char a=s.charAt(0);
            for (int j = 1; j <s.length() ; j++) {
                if (s.charAt(j)!=s.charAt(j-1)){
                    System.out.print(count+""+a);
                    newString+=""+count+""+a;
                    a=s.charAt(j);
                    count=1;
                }else{
                    count++;
                }
            }
            System.out.println(count+""+a);
            newString+=""+count+""+a;
            s=newString;
            i++;
        }
    }

}
