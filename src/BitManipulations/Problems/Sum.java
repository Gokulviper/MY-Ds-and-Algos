package BitManipulations.Problems;

class Sum {
    public static void main(String[] args) {
        System.out.println(getSum(2,3));
        System.out.println('a'^'b'^'b');
    }
    public static int getSum(int a, int b) {
      int sum,carry;
        while(b != 0){
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}