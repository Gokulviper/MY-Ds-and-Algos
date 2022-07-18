package BitManipulations.Problems;
/* find the left side of the bits
  16 ->10000
	19  ->10011
	first find the common in the  both range
	you can write binary representation of 16 to 19 you will understand
	firrst three bits 100 is common we can find the
	we simply left shifted become both are equal
	first -> 1000 1001
	second time ->100 100 now is same
	we incremnt counter for how many times we shifter we need to insert that bits
	finally take right or left both is same
	left << count simply insert the value and return it*/
class RangeAndBetweenNumbers {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        int count=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            count++;
        }
        return left <<=count;
    }
}