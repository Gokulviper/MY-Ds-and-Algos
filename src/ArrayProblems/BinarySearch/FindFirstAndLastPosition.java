package ArrayProblems.BinarySearch;

class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[]nums={5,7,7,8};


    }
    public int[] searchRange(int[] nums, int target) {
        int[]ans={-1,-1};
        int start=search(nums,target,true);
        int end=search(nums,target,false);
       ans[0]=start;
       ans[1]=end;
       return ans;


    }
    int search(int[]nums,int target,boolean findStartIndex){
        int ans=-1;
        int start=0,end=nums.length;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else{
                ans=mid;
                if (findStartIndex){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return ans;

    }
    public int[] searchRange1(int[] nums, int target) {
        //brute force
        int i=-1,j=-1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]==target){
                i=k;
                break;
            }
        }
           for(int k=nums.length-1;k>=0;k--){
            if(nums[k]==target){
                j=k;
                break;
            }
        }
        return new int[]{i,j};
        
    }
}