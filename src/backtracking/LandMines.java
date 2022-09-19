package backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class LandMines {

    static class Key {
        int x, y;

        Key(int i, int j) {
            x = i;
            y = j;
        }
    }

    static int R = 12, C = 10;
    // These arrays are used to get row and column numbers of 4 neighbours of a
    // given cell
    static int rowNum[] = { -1, 0, 0, 1 };
    static int colNum[] = { 0, -1, 1, 0 };

    // A function to check if a given cell (x, y) is a valid cell or not
    static boolean isValid(int x, int y) {
        if (x < R && y < C && x >= 0 && y >= 0)
            return true;

        return false;
    }

    // A function to mark all adjacent cells of landmines as unsafe. Landmines
    // are shown with number 0
    static void findShortestPath(int mat[][]) {

        int i, j;

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {

                // if a landmines is found
                if (mat[i][j] == 0) {

                    // mark all adjacent cells
                    for (int k = 0; k < 4; k++)
                        if (isValid(i + rowNum[k],
                                j + colNum[k]))
                            mat[i + rowNum[k]][j + colNum[k]] = -1;
                }
            }
        }

        // mark all found adjacent cells as unsafe
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (mat[i][j] == -1)
                    mat[i][j] = 0;
            }
        }

        int dist[][] = new int[R][C];

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++)
                dist[i][j] = -1;
        }

        Queue<Key> q = new LinkedList<Key>();

        for (i = 0; i < R; i++) {
            if (mat[i][0] == 1) {
                q.add(new Key(i, 0));
                dist[i][0] = 0;
            }
        }

        while (!q.isEmpty()) {

            // gives head element
            Key k = q.peek();

            // removes head element
            q.poll();

            int d = dist[k.x][k.y];

            int x = k.x;
            int y = k.y;

            for (int ki = 0; ki < 4; ki++) {

                int xp = x + rowNum[ki];
                int yp = y + colNum[ki];

                if (isValid(xp, yp) && dist[xp][yp] == -1 && mat[xp][yp] == 1) {
                    dist[xp][yp] = d + 1;
                    q.add(new Key(xp, yp));
                }
            }
        }

        // stores minimum cost of shortest path so far
        int ans = Integer.MAX_VALUE;

        // start from first column and take minimum
        for (i = 0; i < R; i++) {
            if (mat[i][C - 1] == 1
                    && dist[i][C - 1] != -1) {
                ans = Math.min(ans, dist[i][C - 1]);
            }
        }

        if (ans == Integer.MAX_VALUE)
            System.out.println("NOT POSSIBLE");

        else
            System.out.println("Length of shortest safe route is " + ans);
    }

    // Driver code
    public static void main(String[] args) {

        // input matrix with landmines shown with number 0
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

        // find shortest path
        findShortestPath(mat);
    }
}
