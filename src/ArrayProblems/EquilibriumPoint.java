package ArrayProblems;

class EquilibriumPoint {

    public static void main(String[] args) {
        long[]a= {1,3,5,2,2};
        System.out.println(equilibriumPoint( a,a.length));
    }
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long nums[], int n) {
        if(nums.length==1)return 1;
        if(nums.length==2)return -1;
int a=1,b=0;
   for(int i=0;i<nums.length;i++){
       if(i>0){
        b=sum(nums,0,i-1);
       }
       if(i<nums.length-1){
           a=sum(nums,i+1,nums.length-1);
       }
       if(a==b)return i+1;
   }
   return -1;
    }
    public static int sum(long[]nums,int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=nums[i];
        }
        return sum;
    }
}