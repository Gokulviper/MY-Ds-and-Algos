package ArrayProblems;

class KthMisssingPositiveNumber {
    public static void main(String[] args) {
int[]nums={3,6,7};int k=4;
        System.out.println(findKthPositive(nums,k)) ;

    }
    public static int findKthPositive(int[] nums, int k) {
       int n=1;
       boolean front=false;
       if (n<nums[0]){  //5 6 7 k=3
           while (n<nums[0]&&k-->0){
               front=true;
               n++;
           } }
       n-=1;
       if (k<=0){
           return n;
       }else if(front){
           n=n;
           k+=1;
       }
       else n=1;
       int missing=0;
       int i=0;
       while (i< nums.length){
           if (nums[i]!=n){
               k--;
               missing=n;
             n++;
           }else{
               i++;
               n++;
           }
           if (k==0){
               return missing;
           } }
       n-=1;
       while (k-->0){
           n++;
       }
       return n;
    }
}