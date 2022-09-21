package backtracking;

public class Hurdles {

    static int R = 3;
    static int C = 10;

    // A Pair to store status of a cell. Found is set to
    // true of destination is reachable and value stores
    // distance of longest path
    static class Pair {

        // True if destination is found
        boolean found;

        // Stores cost of longest path from current cell to destination cell
        int val;

        Pair(boolean x, int y) {
            found = x;
            val = y;
        }
    }

    // Function to find Longest Possible Route in the
    // matrix with hurdles. If the destination is not reachable
    // the function returns false with cost Integer.MAX_VALUE.
    // (i, j) is source cell and (x, y) is destination cell.

    static Pair findLongestPathUtil(int mat[][], int i, int j, int x, int y, boolean visited[][]) {

        // If (i, j) itself is destination, return true
        if (i == x && j == y)
            return new Pair(true, 0);

        // If not a valid cell, return false
        if (i < 0 || i >= R || j < 0 || j >= C || mat[i][j] == 0 || visited[i][j])
            return new Pair(false, Integer.MAX_VALUE);

        // Include (i, j) in current path i.e. set visited(i, j) to true
        visited[i][j] = true;

        // res stores longest path from current cell (i, j) to
        // destination cell (x, y)
        int res = Integer.MIN_VALUE;

        // Go left from current cell
        Pair sol = findLongestPathUtil(mat, i, j - 1, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);

        // Go right from current cell
        sol = findLongestPathUtil(mat, i, j + 1, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);

        // Go up from current cell
        sol = findLongestPathUtil(mat, i - 1, j, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);

        // Go down from current cell
        sol = findLongestPathUtil(mat, i + 1, j, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);

        // Backtrack
        visited[i][j] = false;

        if (res != Integer.MIN_VALUE)
            return new Pair(true, res + 1);
        else
            return new Pair(false, Integer.MAX_VALUE);

    }

    static void findLongestPath(int mat[][], int i, int j, int x, int y) {

        boolean visited[][] = new boolean[R][C];
        Pair p = findLongestPathUtil(mat, i, j, x, y, visited);

        if (p.found)
            System.out.println("Length of longest possible route is " + p.val);
        else
            System.out.println("Destination not reachable from given source");

    }

    // Time Complexity - O(4^(R*C))
    public static void main(String[] args) {

        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        findLongestPath(mat, 0, 0, 2, 10);

    }
}
