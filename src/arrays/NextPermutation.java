package arrays;

import java.util.Arrays;

public class NextPermutation {

    // Function to swap the data
    public static int[] swap(int data[], int left, int right) {

        // Swap the data
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;

        // Return the updated array
        return data;
    }

    public static int[] reverse(int data[], int left, int right) {

        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }

        // Return the updated array
        return data;
    }

    // Function to find the next permutation of the given Integer array
    public static boolean findNextPermutation(int data[]) {

        if (data.length <= 1)
            return false;

        int last = data.length - 2;

        // Find the longest non-increasing suffix and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }

        // If there is no increasing pair there is no higher order permutation
        if (last < 0) {
            data = reverse(data, 0, data.length - 1);
            return false;
        }

        int nextGreater = data.length - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and the pivot
        data = swap(data, nextGreater, last);

        // Reverse the suffix
        data = reverse(data, last + 1, data.length - 1);

        // Return true as the next_permutation is done
        return true;
    }

    // Time COmplexity - O(n), Auxillary Space - O(1)
    public static void main(String args[]) {

        int data[] = { 3, 2, 1 };
        if (!findNextPermutation(data))
            System.out.println(Arrays.toString(data));
        else {
            System.out.println(Arrays.toString(data));
        }
    }

}
