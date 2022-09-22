package arrays;

import java.util.*;

public class MaxSubArray {

    // Function to print the elements of Subarray with maximum sum
    static void SubarrayWithMaxSum(Vector<Integer> nums) {

        // Initialize currMax and globalMax with first value of nums
        int currMax = nums.get(0), globalMax = nums.get(0);

        // Initialize endIndex , startIndex , globalMaxStartIndex
        int endIndex = 0;
        int startIndex = 0, globalMaxStartIndex = 0;

        // Iterate for all the elements of the array
        for (int i = 1; i < nums.size(); ++i) {

            // Update currMax and startIndex
            if (nums.get(i) > nums.get(i) + currMax) {
                currMax = nums.get(i);
                startIndex = i; // Update the new startIndex
            }
            // Update currMax
            else if (nums.get(i) < nums.get(i) + currMax) {
                currMax = nums.get(i) + currMax;
            }

            // Update globalMax and globalMaxStartIndex
            if (currMax > globalMax) {
                globalMax = currMax;
                endIndex = i;
                globalMaxStartIndex = startIndex;
            }
        }

        // Printing the elements of subarray with max sum
        for (int i = globalMaxStartIndex; i <= endIndex; ++i) {
            System.out.print(nums.get(i) + " ");
        }
    }

    // Time Complexity O(n) , Auxillary O(1)
    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<Integer>();
        arr.add(-2);
        arr.add(-5);
        arr.add(6);
        arr.add(-2);
        arr.add(-3);
        arr.add(1);
        arr.add(5);
        arr.add(-6);
        // Function call
        SubarrayWithMaxSum(arr);
    }
}
