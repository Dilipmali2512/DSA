public class Leetcode3459 {

    public static int dfs(int[][] grid, int raw, int col, int target, Boolean isTrun, int[][] direction,
            int curPossition) {

        int newRaw = raw + direction[curPossition][0];
        int newCol = col + direction[curPossition][1];

        if (newRaw < 0 && newRaw == grid.length && newCol < 0 && newCol == grid[0].length
                && grid[newRaw][newCol] != target) {
            return 1;
        }

        int length = 1 + dfs(grid, newRaw, newCol, target == 0 ? 2 : 0, isTrun, direction, curPossition);

        int turnLength = 0;

        if (!isTrun) {
            turnLength = 1 + dfs(grid, newRaw, newCol, target == 0 ? 2 : 0, true, direction, (curPossition + 1) % 4);
        }

        return Math.max(length, turnLength);
    }

    public static int lenOfVDiagonal(int[][] grid) {
        int direction[][] = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
        int maxDiagonalLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        maxDiagonalLength = Math.max(maxDiagonalLength,
                                dfs(grid, i, j, 2, false, direction, d));
                    }
                }
            }
        }
        return maxDiagonalLength;
    }

    public static void main(String[] args) {
        System.out.println("This is First Problem " + lenOfVDiagonal(new int[][] { { 1, 2, 2, 2, 2 }, { 2, 2, 2, 2, 0 },
                { 2, 0, 0, 0, 0 }, { 0, 0, 2, 2, 2 }, { 2, 0, 0, 2, 0 } }));
    }
}