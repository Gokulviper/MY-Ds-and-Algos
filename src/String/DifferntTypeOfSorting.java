package String;
import java.util.*;

public class DifferntTypeOfSorting {
    public static void main(String[] args) {
      int[]  arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
      int[]ans=  relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
      int[]freq=new int[1001];
      int[]ans=new int[arr1.length];
     for(int num:arr1){
         freq[num]++;
     }
     int j=0;
     for(int i=0;i< arr2.length;i++){
         while(freq[arr2[i]]-->0){
             ans[j++]=arr2[i];
         }
     }
     for(int i=0;i< freq.length;i++){
         while (freq[i]-->0){
             ans[j++]=i;
         }
     }
     return ans;
    }

}
