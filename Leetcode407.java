public class Leetcode407 {

    public static int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;
        int maxWaterLeft[][] = new int[m][n];
        int maxWaterRight[][] = new int[m][n];

        int maxWaterUp[][] = new int[m][n];
        int maxWaterDown[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            maxWaterLeft[i][0] = heightMap[i][0];
            for (int j = 1; j < n; j++) {
                maxWaterLeft[i][j] = Math.max(maxWaterLeft[i][j - 1], heightMap[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            maxWaterRight[i][n - 1] = heightMap[i][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                maxWaterRight[i][j] = Math.max(maxWaterRight[i][j + 1], heightMap[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            maxWaterDown[m - 1][i] = heightMap[m - 1][i];
            for (int j = m - 2; j >= 0; j--) {
                maxWaterDown[j][i] = Math.max(maxWaterDown[j + 1][i], heightMap[j][i]);
            }
        }

        for (int i = 0; i < n; i++) {
            maxWaterUp[0][i] = heightMap[0][i];
            for (int j = 1; j < m; j++) {
                maxWaterUp[j][i] = Math.max(maxWaterUp[j - 1][i], heightMap[j][i]);
            }
        }

        int water = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min1 = Math.min(maxWaterLeft[i][j], maxWaterRight[i][j]);
                int min2 = Math.min(maxWaterDown[i][j], maxWaterUp[i][j]);

                water += Math.max(Math.min(min1, min2) - heightMap[i][j], 0);

            }
        }

        return water;

    }

    public static void main(String[] args) {
        System.out.println(
                trapRainWater(new int[][] { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } }));
    }
}