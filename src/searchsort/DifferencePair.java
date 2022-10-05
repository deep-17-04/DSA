package searchsort;

import java.util.HashMap;

public class DifferencePair {

    static boolean findPair(int[] arr, int size, int n) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Traverse the array
        for (int i = 0; i < size; i++) {

            // Update frequency of arr[i]
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if (n == 0 && map.get(arr[i]) > 1)
                return true;
        }

        if (n == 0)
            return false;

        for (int i = 0; i < size; i++) {

            if (map.containsKey(n + arr[i])) {
                System.out.print("Pair Found: (" + arr[i] + ", " + (n + arr[i]) + ")");
                return true;
            }
        }

        System.out.print("No Pair found");
        return false;
    }

    // Time Complexity - O(n), Auxillary Space - O(n)
    public static void main(String[] args) {

        int[] arr = { 1, 8, 30, 40, 100 };
        int size = arr.length;
        int n = -60;
        findPair(arr, size, n);
    }
}
