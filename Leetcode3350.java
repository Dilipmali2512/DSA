import java.util.ArrayList;
import java.util.List;

public class Leetcode3350 {

    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int len = nums.size();

        int ans = 1;
        int len1 = 1;
        int len2 = 1;
        for (int i = len - 2; i > 0; i--) {

            if (nums.get(i) > nums.get(i - 1)) {
                len1++;
            } else {
                len2 = len1;
                len1 = 1;
            }

            int ans1 = Math.min(len1, len2);
            int ans2 = Math.max((int) Math.floor(Math.max(len1, len2) / 2), ans1);
            ans = Math.max(ans, ans2);
        }
        return ans;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1));
        System.out.println(maxIncreasingSubarrays(list));
    }
}
