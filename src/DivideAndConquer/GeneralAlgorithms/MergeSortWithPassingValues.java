package DivideAndConquer.GeneralAlgorithms;

public class MergeSortWithPassingValues {
    // Merges two subarrays of arr[].
    // First subarray is arr[Start..mid]
    // Second subarray is arr[mid+1..end]
    void merge(int arr[], int Start, int mid, int end)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid - Start + 1;
        int n2 = end - mid;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[Start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = Start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[start..end] using
    // merge()
    void sort(int arr[], int start, int end)
    {
        if (start < end) {
            // Find the middle point
            int m =start+ (end-start)/2;

            // Sort first and second halves
            sort(arr, start, m);
            sort(arr, m + 1, end);

            // Merge the sorted halves
            merge(arr, start, m, end);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);



        System.out.println("\nSorted array");
        printArray(arr);
    }
}

