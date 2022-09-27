package arrays;

import java.util.*;

public class SubArrayK {

    static int longestSubarrWthSumDivByK(int arr[], int n, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int max_len = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // To handle negavtive values as well
            int mod = ((sum % k) + k) % k;

            if (mod == 0)
                max_len = i + 1;

            if (!map.containsKey(mod))
                map.put(mod, i);
            else {
                int sz = i - map.get(mod);
                max_len = Math.max(max_len, sz);
            }
        }

        return max_len;
    }

    // Time Complexity - O(n), Auxillary Space - O(k)
    public static void main(String[] args) {
        int arr[] = { 2, 7, 6, 1, 4, 5 };
        int n = arr.length;
        int k = 3;

        System.out.println("Length = " + longestSubarrWthSumDivByK(arr, n, k));
    }
}
