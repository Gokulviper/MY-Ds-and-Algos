package BitManipulations.Problems;

public class counting1its {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int count=0;
        for(int i=0; i<=31; i++) {
            if(((n>>i) &1) == 1){
                count++; 
            }
        }
        return count;    }  
   
}