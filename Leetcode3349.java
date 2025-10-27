import java.util.ArrayList;
import java.util.List;

public class Leetcode3349 {
    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        if (n < 2 * k) {
            return false;
        }

        for (int i = 0; i <= n - 2 * k; i++) {
            boolean firstHalf = false;
            boolean secondHalf = false;
            int j;
            for (j = i + 1; j < i + k; j++) {
                if (!(nums.get(j) > nums.get(j - 1))) {
                    break;
                }
            }
            if (j == i + k) {
                firstHalf = true;
            }

            if (firstHalf) {
                for (j = i + k + 1; j < i + 2 * k; j++) {
                    if (!(nums.get(j) > nums.get(j - 1))) {
                        break;
                    }
                }
            }

            if (j == i + 2 * k) {
                secondHalf = true;
            }

            if (firstHalf && secondHalf) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>() {
            {
                // -3,-19,-8,-16
                add(-3);
                add(-19);
                add(-8);
                add(-16);

            }
        };
        System.out.println(hasIncreasingSubarrays(list, 2));
    }
}
