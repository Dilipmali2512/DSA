public class Leetcode2257 {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        // guard 1
        // wall -1
        // see 2
        // cant 0
        int[][] grid = new int[m][n];

        for (int[] cell : walls) {
            grid[cell[0]][cell[1]] = -1;
        }

        for (int[] cell : guards) {
            int i = cell[0];
            int j = cell[1];
            visitSeeCell(i, j, grid);
            grid[i][j] = 1;
        }

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;

    }

    public static void visitSeeCell(int row, int col, int[][] grid) {

        // visit left
        for (int i = col; i >= 0; i--) {
            if (grid[row][i] == -1 || grid[row][i] == 1 || grid[row][i] == 2) {
                break;
            }
            grid[row][i] = 2;
        }

        // visit right
        for (int i = col; i < grid[0].length; i++) {
            if (grid[row][i] == -1 || grid[row][i] == 1 || grid[row][i] == 3) {
                break;
            }
            grid[row][i] = 3;
        }

        // visit up
        for (int i = row; i >= 0; i--) {
            if (grid[i][col] == -1 || grid[i][col] == 1 || grid[i][col] == 4) {
                break;
            }
            grid[i][col] = 4;
        }

        // visit down
        for (int i = row; i < grid.length; i++) {
            if (grid[i][col] == -1 || grid[i][col] == 1 || grid[i][col] == 5) {
                break;
            }
            grid[i][col] = 5;
        }
    }

    public static void main(String[] args) {
        System.out.println(countUnguarded(3, 3, new int[][] { { 1, 1 } },
                new int[][] { { 0, 1 }, { 1, 0 }, { 2, 1 }, { 1, 2 } }));
    }
}
