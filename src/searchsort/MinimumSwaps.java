package searchsort;

import java.util.*;

public class MinimumSwaps {

    public static int minSwaps(int[] arr, int N) {

        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);

        // Hashmap which stores the indexes of the input array
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) {
            h.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {

            // This is checking whether the current element is
            // at the right place or not
            if (arr[i] != temp[i]) {
                ans++;
                int init = arr[i];

                // If not, swap this element with the index of the
                // element which should come here
                swap(arr, i, h.get(temp[i]));

                // Update the indexes in the HashMap accordingly
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Time Complexity - O(nlogn), Auxillary Space - O(n)
    public static void main(String[] args) throws Exception {

        int[] a = { 101, 758, 315, 730, 472, 619, 460, 479 };
        int n = a.length;
        System.out.println(minSwaps(a, n));
    }
}