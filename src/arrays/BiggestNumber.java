package arrays;

import java.util.*;

public class BiggestNumber {

    static void printLargest(ArrayList<Integer> arr) {

        Collections.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {

                int X = x;
                int Y = y;

                int countx = 0;
                int county = 0;

                // Count length of X
                while (x > 0) {
                    countx++;
                    x /= 10;
                }

                // Count length of Y
                while (y > 0) {
                    county++;
                    y /= 10;
                }

                // Reinitialize
                x = X;
                y = Y;

                while (countx > 0) {
                    countx--;
                    Y *= 10;
                }

                while (county > 0) {
                    county--;
                    X *= 10;
                }

                // Append x to y
                Y += x;

                // Append y to x
                X += y;

                return -X + Y;
            }
        });

        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i));
    }

    // Time Complexity - O(nlogn), Auxillary Space - O(1)
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(54);
        arr.add(546);
        arr.add(548);
        arr.add(60);

        printLargest(arr);

    }
}
