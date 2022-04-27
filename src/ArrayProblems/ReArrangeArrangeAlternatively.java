package ArrayProblems;

import java.util.Arrays;

public class ReArrangeArrangeAlternatively {
    public static void main(String[] args) {
        int[]nums={1,2,3,4,5,6,7,8,9,10};
        reArrange(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void reArrange(int[] arr) {
        int n= arr.length;
        //Initialising index of first minimum and first maximum element.
        int max_idx = n - 1, min_idx = 0;

        //Storing maximum element of array.
        long max_elem = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {

            //At even index, we have to put maximum elements in decreasing order.
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                //Updating maximum index.
                max_idx--;
            }

            //At odd index, we have to put minimum elements in increasing order.
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                //Updating minimum index.
                min_idx++;
            }
        }

        //Dividing array elements by maximum element to get the result.
        for (int i = 0; i < n; i++)
            arr[i] = (int) (arr[i] / max_elem);

    }
}
