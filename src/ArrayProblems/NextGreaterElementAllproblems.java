package ArrayProblems;

public class NextGreaterElementAllproblems {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //brute force
        int[]ans=new int[nums1.length];
        int k=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            int num=nums1[i];
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==num){
                    max=num;
                    while(j<nums2.length){
                        if(nums2[j]>max){
                            max=nums2[j];
                            break;
                        }
                        j++;
                    }
                }
            }
            ans[k++]=(max==num)?-1:max;

        }
        return ans;
    }
}
