package backtracking;

import java.util.*;

public class CombinationalSum {

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        // First do hashing since HashSet does not always Sort
        // Removing the duplicates using HashSet and Sorting the ArrayList.

        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);

        findNumbers(ans, arr, sum, 0, temp);
        return ans;
    }

    static void findNumbers(ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> arr, int sum, int index,
            ArrayList<Integer> temp) {

        // Base Case
        if (sum == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.size(); i++) {

            // Checking that sum does not become negative.
            if ((sum - arr.get(i)) >= 0) {

                // Adding element which can contribute to Sum.
                temp.add(arr.get(i));

                findNumbers(ans, arr, sum - arr.get(i), i, temp);

                // Removing element from list (backtracking)
                temp.remove(arr.get(i));
            }
        }
    }

    // Time Complexity - O(n^2), Auxillary Space - O(n^2)
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);

        int sum = 8;

        ArrayList<ArrayList<Integer>> ans = combinationSum(arr, sum);

        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }

        // Print
        for (int i = 0; i < ans.size(); i++) {

            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println(")");
        }
    }
}
