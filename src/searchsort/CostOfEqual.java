package searchsort;

public class CostOfEqual {

    public static int minCostToMakeElementEqual(int a[], int n) {

        int y;
        int s = 0;

        // If there are odd elements, We choose middle element else Avg.
        if (n % 2 == 1)
            y = a[n / 2];
        else
            y = (a[n / 2] + a[(n - 2) / 2]) / 2;

        // After deciding the final value, find the result.
        for (int i = 0; i < n; i++)
            s += Math.abs(a[i] - y);

        return s;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {
        int a[] = { 4, 100, 101 };
        int n = a.length;

        System.out.println(minCostToMakeElementEqual(a, n));
    }
}
