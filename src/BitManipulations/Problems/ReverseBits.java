package BitManipulations.Problems;

public class ReverseBits {
    // you need treat n as an unsigned value
    public static void main(String[] args) {
      
    }
    public int reverseBits(int n) {
         int res = 0;
        for(int i=0; i<=31; i++) {
            if(checkBit(n, i)) {
                int pos = 31 - i;
                res = (1 << pos) | res; //setting the bit at pos
            }
        }
        return res;
    }
    
    private boolean checkBit(int N, int i) {
        return ((N>>i) & 1) == 1; 
    }
}