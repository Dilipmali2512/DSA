import java.util.Arrays;

public class Leetcode976 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = length - 1; i > 1; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];

            if (a < b + c) {
                return a + b + c;
            }
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
