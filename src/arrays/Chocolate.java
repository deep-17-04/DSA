package arrays;

import java.util.Arrays;

public class Chocolate {

    static int findMinDiff(int arr[], int n, int m) {

        if (m == 0 || n == 0)
            return 0;

        if (n < m)
            return -1;

        // Sort the given packets
        Arrays.sort(arr);

        // Largest number of chocolates
        int min_diff = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }

    // Time Complexity - O(nlogn) Auxillary - O(1)
    public static void main(String[] args) {
        int arr[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };

        int m = 7;
        int n = arr.length;
        System.out.println("Minimum difference is " + findMinDiff(arr, n, m));

    }
}
