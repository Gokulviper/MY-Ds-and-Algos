package BitManipulations.Problems;

class HammingDistance {
    public int hammingDistance(int n, int y) {
            
        int count=0;
        for(int i=0; i<=31; i++) {
            if(((n>>i) &1) !=((y>>i)&1)){
                count++; 
            }
        }
        return count;
    }
}