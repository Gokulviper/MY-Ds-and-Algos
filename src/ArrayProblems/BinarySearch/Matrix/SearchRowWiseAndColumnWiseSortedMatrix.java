package ArrayProblems.BinarySearch.Matrix;

public class SearchRowWiseAndColumnWiseSortedMatrix {
    public static void main(String[] args) {

    }
    static int[]search(int[][]nums,int target) {
        int start = 0, end = nums.length - 1;
        while ( start< nums.length&&end>=0){
            if(nums[start][end]==target){
                return new int[]{start,end};
            }
            if (nums[start][end]<target){
                start++;
            }else {
                end--;
            }
        }
        return new int[]{-1,-1};
    }
}
