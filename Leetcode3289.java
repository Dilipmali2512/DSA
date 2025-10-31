import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3289 {
    public static int[] getSneakyNumbers(int[] nums) {
        int ans[] = new int[2];
        Set<Integer> set = new HashSet<>();
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                ans[k++] = nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = getSneakyNumbers(new int[] {0,1,1,0});
        System.out.println(ans[0] + " " + ans[1]);

    }
}
