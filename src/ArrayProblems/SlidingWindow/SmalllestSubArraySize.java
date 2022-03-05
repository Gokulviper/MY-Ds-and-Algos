package ArrayProblems.SlidingWindow;

public class SmalllestSubArraySize {
    public static void main(String[] args) {
        int[]nums={4,2,1,7,8,1,2,8,1,0};
        System.out.println(smallestsubArraySize(nums,8
        ));
    }

    private static int smallestsubArraySize(int[] nums,int targetsum) {
        int minWindowSize=Integer.MAX_VALUE;
        int currentWindowSum=0;
        int  j=0;
        for (int i=0;i<nums.length;i++){
            currentWindowSum+=nums[i];
            while(currentWindowSum>=targetsum){
                minWindowSize=Math.min(minWindowSize,i-j+1);
                currentWindowSum-=nums[j];
                j++;
            }
        }
        return minWindowSize;
    }

}
