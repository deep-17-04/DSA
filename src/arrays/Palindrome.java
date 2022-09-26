package arrays;

public class Palindrome {

    static int findMinOps(int[] arr, int n) {

        int ans = 0;

        // Start from two corners
        for (int i = 0, j = n - 1; i <= j;) {
            // If corner elements are same, problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }

            // If left element is greater, then we merge right two elements
            else if (arr[i] > arr[j]) {
                j--;
                arr[j] += arr[j + 1];
                ans++;
            }

            // Else we merge left two elements
            else {
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }

        return ans;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 4, 6, 9, 1 };
        System.out.println("Count of minimum operations is "
                + findMinOps(arr, arr.length));

    }
}
