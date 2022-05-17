package ArrayProblems.Hashing;

import java.util.HashMap;

class ContinousSubArraySum {
  public static void main(String[] args) {

  }
    public boolean checkSubarraySum(int[] nums, int k) {
      if(nums.length<2) return false;
      HashMap<Integer,Integer> hsmap=new HashMap<>();
      int curSum=0;
      for(int i=0;i<nums.length;i++){
        curSum+=nums[i];
        if(i!=0 && curSum%k==0) return true;
        if(hsmap.containsKey(curSum%k)){
          if (i-hsmap.get(curSum%k)>1) return true;
        }else{
          hsmap.put(curSum%k,i);
        }
      }
      return false;
    }
}