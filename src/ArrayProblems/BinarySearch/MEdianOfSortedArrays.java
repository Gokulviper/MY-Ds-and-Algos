package ArrayProblems.BinarySearch;

import java.util.Arrays;

class MEdianOfSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,3},nums2={2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //brute force
      int[]ans=  merge(nums1,nums2);
    int n=ans.length;
    int start=0,end=ans.length-1;
    if(n%2!=0){
         int  mid=(start+end)/2;
         return (double) ans[mid];
    }else{
       int mid=(start+end)/2;
       return (double) (ans[mid]+ans[mid+1])/2;
    }

    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int []ans=new int[nums1.length+ nums2.length] ;
        int k=0;
        for(int i=0;i<nums1.length;i++){
            ans[k++]= nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            ans[k++]= nums2[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}