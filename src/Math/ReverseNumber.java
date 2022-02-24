package Math;

public class ReverseNumber {
    public static void main(String[] args) {
        int num=120;
        System.out.println(reverse(num));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }
    public static int reverse(int num) {
/*To explain, lets assume that \text{rev}rev is positive.
  *If temp=rev⋅10+pop causes overflow, then it must be that
    rev≥INTMAX
         10
*rev≥ INTMAX then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop is guaranteed to overflow.
        10
*If rev == INTMAX  then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop will overflow if and only if \text{pop} > 7pop>7
            10
  */
        int ans = 0;
        while (num != 0) {
            int last = num % 10;
            num /= 10;
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && last > 7)) return 0; // 2147483647

            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && last < -8)) return 0;//-2147483648
            ans = ans * 10 + last;
        }
        return ans;
    }

}
