package arrays;

public class ProductExceptSelf {

    public static long[] productExceptSelf(int a[], int n) {
        long prod = 1;
        long flag = 0;

        // Product of all elements
        for (int i = 0; i < n; i++) {
            // Counting number of elements which have value 0
            if (a[i] == 0)
                flag++;
            else
                prod *= a[i];
        }

        // Creating a new array of size n
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {

            // If number of elements in array with value 0 is more than 1 than
            // each value in new array will be equal to 0
            if (flag > 1) {
                arr[i] = 0;
            } else if (flag == 0) {
                arr[i] = (prod / a[i]);
            } else if (flag == 1 && a[i] != 0) {
                arr[i] = 0;
            } else
                arr[i] = prod;
        }
        return arr;
    }

    public static void main(String args[]) {
        int n = 5;
        int[] array = { 10, 3, 0, 6, 2 };

        long[] ans = new long[n];
        ans = productExceptSelf(array, n);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
