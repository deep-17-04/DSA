package searchsort;

import java.util.*;

public class SubArrays0 {

    static class Pair {
        int first, second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    static ArrayList<Pair> findSubArrays(int[] arr, int n) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == 0)
                out.add(new Pair(0, i));

            ArrayList<Integer> al = new ArrayList<>();

            if (map.containsKey(sum)) {
                al = map.get(sum);

                for (int it = 0; it < al.size(); it++) {
                    out.add(new Pair(al.get(it) + 1, i));
                }
            }

            al.add(i);
            map.put(sum, al);
        }
        return out;
    }

    // Utility function to print all subarrays with sum 0
    static void print(ArrayList<Pair> out) {

        for (int i = 0; i < out.size(); i++) {
            Pair p = out.get(i);
            System.out.println("Subarray found from Index "
                    + p.first + " to " + p.second);
        }
    }

    // Time Complexity - O(n), Auxillary Space - O(n)
    public static void main(String args[]) {

        int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        int n = arr.length;

        ArrayList<Pair> out = findSubArrays(arr, n);
        if (out.size() == 0)
            System.out.println("No subarray exists");
        else
            print(out);
    }
}
