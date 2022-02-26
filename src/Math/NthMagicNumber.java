package Math;

public class NthMagicNumber {
    public static void main(String[] args) {
        System.out.println(NthMagicNumber(5));
        System.out.println(findDecimalCountUsingLog(600));
    }

    private static int findBinaryCountUsingLog(int num) {
        return(int) ((int)Math.log(num)/Math.log(2)+1);
    }
    private static int findDecimalCountUsingLog(int num) {
        return(int) ((int)Math.log(num)/Math.log(10)+1);
    }

    private static int findBinaryCount(int num) {
        int count=0;
        while (num>0){
            count++;
            num=num>>1;
        }
        return count;
    }
    private static int NthMagicNumber(int num) {
        int ans=0;
        int base=5;
        while (num>0){
            int last=num&1;
            num=num>>1;
            ans+=last*base;
            base=base*5;
        }
        return ans;
    }

}
