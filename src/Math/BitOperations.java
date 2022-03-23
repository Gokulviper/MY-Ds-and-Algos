package Math;

public class BitOperations {
    public static void main(String[] args) {
        int n=5;
        System.out.println(~n);
    }
    private static int FindIthBit(int num){
        return num&(1<<(num-1));
    }

}
