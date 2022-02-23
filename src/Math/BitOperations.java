package Math;

public class BitOperations {
    public static void main(String[] args) {

    }
    private static int FindIthBit(int num){
        return num&(1<<(num-1));
    }

}
