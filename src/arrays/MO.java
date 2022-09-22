package arrays;

import java.util.*;

// Class to represent a query range
class Query {
    int L;
    int R;

    Query(int L, int R) {
        this.L = L;
        this.R = R;
    }
}

public class MO {

    // Prints sum of all query ranges. n is size of array m is number of queries.
    static void queryResults(int a[], int n, ArrayList<Query> q, int m) {

        // Find block size
        int block = (int) Math.sqrt(n);

        // Sort all queries so that queries of same blocks are arranged together.
        Collections.sort(q, new Comparator<Query>() {

            /*
             * Function used to sort all queries so that all queries
             * of the same block are arranged together and within a block,
             * queries are sorted in increasing order of R values.
             */
            public int compare(Query x, Query y) {

                // Different blocks, sort by block.
                if (x.L / block != y.L / block)
                    return (x.L < y.L ? -1 : 1);

                // Same block, sort by R value
                return (x.R < y.R ? -1 : 1);
            }
        });

        // Initialize current L, current R and current Sum
        int currL = 0, currR = 0;
        int currSum = 0;

        // Traverse through all queries
        for (int i = 0; i < m; i++) {
            int L = q.get(i).L, R = q.get(i).R;

            while (currL < L) {
                currSum -= a[currL];
                currL++;
            }

            while (currL > L) {
                currSum += a[currL - 1];
                currL--;
            }

            while (currR <= R) {
                currSum += a[currR];
                currR++;
            }

            while (currR > R + 1) {
                currSum -= a[currR - 1];
                currR--;
            }

            // Print sum of current range
            System.out.println("Sum of [" + L + ", " + R + "] is " + currSum);
        }
    }

    public static void main(String argv[]) {
        ArrayList<Query> q = new ArrayList<Query>();
        q.add(new Query(4, 6));
        q.add(new Query(1, 3));
        q.add(new Query(2, 4));

        int a[] = { 1, 1, 2, 1, 3, 4, 5, 2, 8 };
        queryResults(a, a.length, q, q.size());
    }
}
