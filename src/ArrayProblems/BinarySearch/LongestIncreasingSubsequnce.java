package ArrayProblems.BinarySearch;

public class LongestIncreasingSubsequnce {
    public static void main(String[] args) {
      int[]nums={10,9,2,5,3,7,101,18};
        System.out.println( lengthOfLIS(nums));
    }
    /*idea is the current number is the part of sequence nums[i]>tail[j-1]
    then add your sequnce is it smaller number check ceiling alorithm
    //because the increasing sequence is sorted so find the the current index
    which is the correct position
    */

    public static int lengthOfLIS(int[] arr) {
        // optimized one
        int n = arr.length;
        if (n == 0) return 0;
        int[] tail = new int[n];
        tail[0] = arr[0];
        int j = 1;//this is length of the longest sequence
        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[j - 1]){
                tail[j] = arr[i];
                j++;
            }else {
                int ceil = ceil(tail, j - 1, arr[i]);
                //ceiling is next  ggreater number
                tail[ceil] = arr[i];
            }
        }
        return j;
    }
    private static int ceil(int[] arr, int high, int ele){
        int low = 0;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (arr[mid] >= ele){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return high;
    }
}
