package searchsort;

public class NoAdjacent {

    static int findMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++) {
            // Current max excluding i
            excl_new = Math.max(incl, excl);

            // Current max including i
            incl = excl + arr[i];
            excl = excl_new;
        }

        // Return max of incl and excl
        return Math.max(incl, excl);
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
        System.out.println(findMaxSum(arr, arr.length));
    }
}
