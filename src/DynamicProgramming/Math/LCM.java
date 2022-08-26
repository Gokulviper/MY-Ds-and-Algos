package DynamicProgramming.Math;

public class LCM {
    public static void main(String[] args) {
        lcm(15,5);
    }

    private static void lcm(int x, int y) {
        int a;
        a =Math.max(x,y);
        while(true)
        {
            if(a % x == 0 && a % y == 0) {
                System.out.println(a);
                return;
            }

            ++a;
        }
    }
}
