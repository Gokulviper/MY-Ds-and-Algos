package ArrayProblems.BinarySearch;

class SingleElementInSoretdArray {
    public static void main(String[] args) {
  int[]nums={1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        //set the low and high pointers
        int start = 0; //start points at first index
        int end = nums.length - 1; //high points at last index
        int mid = 0; //mid

        //checking the boundary conditions
        if( nums.length == 1) //if there is only one element in the array nums
            return nums[0]; //return that single element

        else if( nums[0] != nums[1]) //if the unique element is at the first index
            return nums[0];

        else if( nums[end] != nums[end-1]) //if the unique element is at the last index
            return nums[end];


        //apply binary search
        /*
        The idea is: unless the unique element appears in the array,
        for every pair of duplicates,
        the first term appears at even index & the 2nd term appears at odd index.
        Once the unique element is appears, for every pair of duplicates,
        the first term appears at odd index & the 2nd term appears at even index.
        */
        while( start <= end)
        {
            mid = start + (end - start)/2;

            //if the mid element is unique, i.e it is not equal to its neighbours
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid]; //return element at mid
            /*
            If the mid is even, and the element at index mid is equal to its next element
            that means, the unique element lies somewhere in the second half.
            So, low pointer is updated.
            Also, if the mid index is odd and the element at mid is equal
            to its previous element, in that case too, unique element lies towards the left
            So, low is updated*/
            else if( (mid % 2 == 0) && (nums[mid] == nums[mid+1]) ||
                    (mid%2 == 1) && nums[mid] == nums[mid-1])
                start = mid+1;
            else //otherwise, end is updated
                end = mid -1 ;
        }

        return -1;
    }
}