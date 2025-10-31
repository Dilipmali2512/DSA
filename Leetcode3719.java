import java.util.HashSet;
import java.util.Set;

public class Leetcode3719 {
    public static int longestBalanced(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);

                }

                if (even.size() == odd.size()) {
                    count = j - i + 1;
                }
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestBalanced(new int[] { 3, 2, 2, 5, 4 }));
    }
}
