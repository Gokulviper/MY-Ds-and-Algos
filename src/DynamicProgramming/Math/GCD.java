package DynamicProgramming.Math;

public class GCD {
    public static void main(String[] args) {
        gcd(24,8);
    }

    private static void gcd(int a, int b) {
            int n=Math.min(a,b);
            int ans=1;
        for (int i = 2; i <n ; i++) {
            while (a%i==0&&b%i==0){
                ans*=i;
                a/=i;
                b/=i;
            }
        }
        System.out.println(ans);
    }
}
