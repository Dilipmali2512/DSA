import java.util.Arrays;

public class Leetcode3354 {
    public static int countValidSelections(int[] nums) {
        int ans = 0;
        boolean isPrev = false;
        boolean isPrevLeftValide = false;
        boolean isPrevRightValide = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (isPrev && isPrevRightValide || helper(Arrays.copyOf(nums, nums.length), i, 1)) {
                    isPrevRightValide = true;
                    ans++;
                }

                if (isPrev && isPrevLeftValide || helper(Arrays.copyOf(nums, nums.length), i, -1)) {
                    isPrevLeftValide = true;
                    ans++;
                }

                isPrev = true;
            } else {
                isPrev = false;
                isPrevLeftValide = false;
                isPrevLeftValide = false;
            }
        }

        return ans;
    }

    public static boolean helper(int[] nums, int index, int diraction) {
        if (index < 0 || index >= nums.length) {
            return false;
        }

        boolean isValide = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                isValide = false;
                break;
            }
        }

        if (isValide) {
            return true;
        }

        if (nums[index] == 0) {
            return helper(nums, index + diraction, diraction);
        } else {
            nums[index] -= 1;
            return helper(nums, index - diraction, -diraction);
        }
    }

    public static int countValidSelections1(int[] nums) {
        int ans = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int halfSum = 0;

        for (int i = 0; i < nums.length; i++) {
            halfSum += nums[i];
            if (nums[i] == 0) {
                if (halfSum * 2 == sum) {
                    ans += 2;
                } else if (Math.abs(sum - 2 * halfSum) == 1) {
                    ans += 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countValidSelections1(new int[] { 1, 0, 2, 0, 3 }));
    }
}