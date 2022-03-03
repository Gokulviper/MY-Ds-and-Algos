package Math;

public class SqrtOfNumber {
    public static void main(String[] args) {
        int n=40;
        int p=3;
        System.out.println(sqtr(n,p));
    }
    public static int mySqrt(int x) {
        long start = 1;
        long end = x/2;
        while (start < end) {
            long mid = (start + end) / 2;
            if (mid * mid > x) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        if (start * start > x) {
            return (int) start - 1;
        }
        return (int) start;
    }

    private static double sqtr(int n, int p) {
        int s=0,e=n;
        double root=0.0;
        while (s<=e){
            int m=s+(e-s)/2;
            if (m*m==n){
                return m;
            }
            if (m*m>n){
                e=m-1;
            }else{
                s=m+1; }
        }
        double incr=0.1;
        for (int i=0;i<p;i++){
            while (root*root<=n){
                root+=incr;
            }
            root-=incr;
            incr/=10;
        }

        return root;
    }
}
