package ArrayProblems;

import java.util.Arrays;

class MergeTwoSortedArrays
{
    public static void main(String[] args) {
        long[]n1={1,3,5,7},n2={0,2,6,8,9};
        System.out.println(Arrays.toString( merge(n1,n2, n1.length, n2.length)));   ;

    }
    //Function to merge the arrays.
    public static long[] merge(long nums1[], long nums2[], int n, int m)
    {
       int i=0,j=0,k=0;
       long[]ans=new long[n+m];
       while(i<n&&j<m){
           if(nums1[i]<=nums2[j]){
           ans[k++]=nums1[i++];
           }
           else{
           ans[k++]=nums2[j++];
           }
       }
       while(i<n){
           ans[k++]=nums1[i++];
       }
       while(j<m){
           ans[k++]=nums2[j++];
       }
        return ans;
    }
   
}