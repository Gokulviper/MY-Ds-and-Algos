package ArrayProblems;

class MajrityElement1 {
    public int majorityElement(int[] nums) {
        int ans=0,count=0;
        for(int num:nums){
           if(count==0){
               ans=num;
           }
            count+=num==ans?1:-1;
        }
        return ans;
    }
}