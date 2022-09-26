package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Overlapping {

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void mergeIntervals(Interval arr[]) {

        // Sort Intervals in Increasing order of start time.
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        // Stores index of last element in output array (modified arr[])
        int index = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[index].end >= arr[i].start) {
                arr[index].end = Math.max(arr[index].end, arr[i].end);

            } else {
                index++;
                arr[index] = arr[i];
            }
        }

        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++) {
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
        }
    }

    // Time Complexity - O(n*Log(n)), Auxillary Space - O(1)
    public static void main(String args[]) {

        Interval arr[] = new Interval[4];
        arr[0] = new Interval(8, 10);
        arr[1] = new Interval(1, 3);
        arr[2] = new Interval(2, 3);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
    }
}
