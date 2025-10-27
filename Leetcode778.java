public class Leetcode778 {

    public static int swimInWater(int[][] grid) {
        int raw = grid.length;
        int col = grid.length;

        return findMinimumTime(0, 0, grid, grid[0][0], new boolean[raw][col]);
    }

    public static int findMinimumTime(int i, int j, int[][] grid, int prev, boolean visitd[][]) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || visitd[i][j]) {
            return Integer.MAX_VALUE;
        }

        visitd[i][j] = true;

        if (i == grid.length - 1 && j == grid.length - 1) {
            visitd[i][j] = false;
            return Math.max(prev, grid[i][j]);
        }

        prev = Math.max(grid[i][j], prev);

        int left = findMinimumTime(i, j + 1, grid, prev, visitd);
        int right = findMinimumTime(i, j - 1, grid, prev, visitd);
        int up = findMinimumTime(i - 1, j, grid, prev, visitd);
        int down = findMinimumTime(i + 1, j, grid, prev, visitd);

        visitd[i][j] = false;

        return Math.min(Math.min(up, down), Math.min(left, right));
    }

    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][] { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 }, { 10, 9, 8, 7, 6 } }));
    }
}
