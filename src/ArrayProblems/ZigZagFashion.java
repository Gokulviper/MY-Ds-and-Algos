package ArrayProblems;

import java.util.Arrays;

class ZigZagFashion {
    public static void main(String[] args) {
        int[]nums={4, 3, 7, 8, 6, 2, 1};
        zigZag(nums,nums.length);
        System.out.println(Arrays.toString(nums));

    }
  static   void zigZag(int arr[], int n) {
      for(int i=1;i<n;i++){
          if(i%2!=0){
              if(arr[i-1]>arr[i]){
                  swap(arr,i-1,i);
              }
          }
          else{
              if(arr[i-1]<arr[i]){
                  swap(arr,i-1,i);
              }
          }
      }
  }
    static void swap(int[]nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }

}