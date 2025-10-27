import java.util.Arrays;
import java.util.Collections;

public class Leetcod3446 {

    public static int[] sortArray(int array[]) {
        Arrays.sort(array); // Sort ascending
        // Reverse manually
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public static int[] sortArray1(int array[]) {
        Arrays.sort(array); // Sort ascending
        return array;
    }

    public static void sortMatrix(int[][] grid) {
        int raw = grid.length;
        int col = grid[0].length;

        int k = 0;
        int m = 0;

        int l = 1;
        int n = 1;

        for (int i = 0; i < raw; i++) {

            int temp[] = new int[col - i];

            for (int j = 0; j < col - i; j++) {
                temp[j] = grid[k][j];
                k++;
            }

            k = m;

            int sortedArr[] = sortArray(temp);
            for (int j = 0; j < sortedArr.length; j++) {
                grid[k][j] = temp[j];
                k++;
            }

            m++;
            k = m;

        }

        for (int i = 0; i < raw - 1; i++) {
            int temp[] = new int[col - i - 1];
            for (int j = 0; j < col - i - 1; j++) {
                temp[j] = grid[j][l];
                l++;
            }

            l = n;

            int sortedArr[] = sortArray1(temp);
            for (int j = 0; j < sortedArr.length; j++) {
                grid[j][l] = temp[j];
                l++;
            }

            n++;
            l = n;

        }

        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        sortMatrix(new int[][] { { 1, 7, 3 }, { 9, 8, 2 }, { 4, 5, 6 } });
    }
}