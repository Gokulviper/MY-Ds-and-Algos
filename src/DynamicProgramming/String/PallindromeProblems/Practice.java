package DynamicProgramming.String.PallindromeProblems;

//import static sun.net.ftp.FtpReplyCode.find;

//import static sun.net.ftp.FtpReplyCode.find;

public class Practice {
    public static void main(String[] args) {
        String s="";
        findstring(s);
    }

    private static void findstring(String s) {

    }

    static void find(int n) {
        int ans=0;
        int sum=0;
        while (n>0){
            int mod=n%10;
            sum+=mod;
            ans=ans*10+mod;
            n/=10;
        }
        System.out.println(ans);
        System.out.println(sum);
    }
}
