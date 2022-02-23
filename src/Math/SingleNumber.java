package Math;

public class SingleNumber {
    public static void main(String[] args) {
        //System.out.println(singleNumber(new int[]{1,4,1,4,3,2,3,2,7}));
        System.out.println(explainSingleNumberProblem(new int[]{-1,1,3,2,-2,-3,7}));

    }

    private static int explainSingleNumberProblem(int[] nums) {
        int single_number=0;
        for(int num:nums){
            single_number+=num;
        }
        return single_number;
    }


    private static int singleNumber(int[] nums) {
        int unique=0;
        for(int num:nums){
            unique^=num;

        }
        return unique;
    }


}
