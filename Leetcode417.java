import java.util.ArrayList;
import java.util.List;

public class Leetcode417 {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isValideCell(i, j, heights, false, new boolean[row][col])
                        && isValideCell(i, j, heights, true, new boolean[row][col])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    public static boolean isValideCell(int i, int j, int[][] heights, boolean isFindPacific, boolean[][] visit) {

        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) {
            return false;
        }

        visit[i][j] = true;

        if (isFindPacific && (i == 0 || j == 0)) {
            return true;
        }

        if (!isFindPacific && (i == heights.length - 1 || j == heights[0].length - 1)) {
            return true;
        }

        return (i + 1 < heights.length && heights[i][j] >= heights[i + 1][j] && !visit[i + 1][j]
                && isValideCell(i + 1, j, heights, isFindPacific, visit))
                || (i - 1 >= 0 && heights[i][j] >= heights[i - 1][j] && !visit[i - 1][j]
                        && isValideCell(i - 1, j, heights, isFindPacific, visit))
                || (j + 1 < heights[0].length && heights[i][j] >= heights[i][j + 1] && !visit[i][j + 1]
                        && isValideCell(i, j + 1, heights, isFindPacific, visit))
                || (j - 1 >= 0 && heights[i][j] >= heights[i][j - 1] && !visit[i][j - 1]
                        && isValideCell(i, j - 1, heights, isFindPacific, visit));

    }

    public static void main(String[] args) {
        pacificAtlantic(new int[][] { { 11, 3, 2, 4, 14, 6, 13, 18, 1, 4, 12, 2, 4, 1, 16 },
                { 5, 11, 18, 0, 15, 14, 6, 17, 2, 17, 19, 15, 12, 3, 14 },
                { 10, 2, 5, 13, 11, 11, 13, 19, 11, 17, 14, 18, 14, 3, 11 },
                { 14, 2, 10, 7, 5, 11, 6, 11, 15, 11, 6, 11, 12, 3, 11 },
                { 13, 1, 16, 15, 8, 2, 16, 10, 9, 9, 10, 14, 7, 15, 13 },
                { 17, 12, 4, 17, 16, 5, 0, 4, 10, 15, 15, 15, 14, 5, 18 },
                { 9, 13, 18, 4, 14, 6, 7, 8, 5, 5, 6, 16, 13, 7, 2 },
                { 19, 9, 16, 19, 16, 6, 1, 11, 7, 2, 12, 10, 9, 18, 19 },
                { 19, 5, 19, 10, 7, 18, 6, 10, 7, 12, 14, 8, 4, 11, 16 },
                { 13, 3, 18, 9, 16, 12, 1, 0, 1, 14, 2, 6, 1, 16, 6 },
                { 14, 1, 12, 16, 7, 15, 9, 19, 14, 4, 16, 6, 11, 15, 7 },
                { 6, 15, 19, 13, 3, 2, 13, 7, 19, 11, 13, 16, 0, 16, 16 },
                { 1, 5, 9, 7, 12, 9, 2, 18, 6, 12, 1, 8, 1, 10, 19 },
                { 10, 11, 10, 11, 3, 5, 12, 0, 0, 8, 15, 7, 5, 13, 19 },
                { 8, 1, 17, 18, 3, 6, 8, 15, 0, 9, 8, 8, 12, 5, 18 },
                { 8, 3, 6, 12, 18, 15, 10, 10, 12, 19, 16, 7, 17, 17, 1 },
                { 12, 13, 6, 4, 12, 18, 18, 9, 4, 9, 13, 11, 5, 3, 14 },
                { 8, 4, 12, 11, 2, 2, 10, 3, 11, 17, 14, 2, 17, 4, 7 },
                { 8, 0, 14, 0, 13, 17, 11, 0, 16, 13, 15, 17, 4, 8, 3 },
                { 18, 15, 8, 11, 18, 3, 10, 18, 3, 3, 15, 9, 11, 15, 15 } });
    }
}
