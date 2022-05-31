package ArrayProblems.BinarySearch;

public class LongestIncreasingSubsequnce {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] arr) {
        // optimized one

        int n = arr.length;
        if (n == 0)
            return 0;
        int[] tail = new int[n];
        tail[0] = arr[0];
        int length = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[length - 1]){
                tail[length] = arr[i];
                length++;
            }else {
                int ceil = LIS_Ceil(tail, length - 1, arr[i]);
                tail[ceil] = arr[i];
            }
        }
        return length;
    }

    private int LIS_Ceil(int[] arr, int high, int ele){
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
