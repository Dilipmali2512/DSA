import java.util.Arrays;

public class Leetcode2300 {

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            long sp = spells[i];
            int left = 0, right = m - 1;
            int index = -1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (sp * potions[mid] >= success) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = (index == -1) ? 0 : (m - index);
        }

        return ans;
    }

    public static void main(String[] args) {
        int ans[] = successfulPairs(new int[] { 3, 1, 2 }, new int[] { 8, 5, 8 }, 16);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}