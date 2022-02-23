package ArrayProblems;

import java.util.Arrays;

public class TopKFrequentElements {
    public static void main(String[] args) {

        int[]nums={1};
        int[]ans=topKFrequent(nums,1);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[]hash=new int[10001];
        int[]ans=new int[k];
        int j=0;
        for(int num:nums){
            hash[num]++;
        }
        int max=Integer.MIN_VALUE;

        for(int i=0;i<k;i++){
            for (int v=0;v< hash.length;v++){

                if(hash[v]>max){

                    max=v;
                }


            } ans[j++]=max;
            hash[max]=0;
        }
return ans;
    }
}
