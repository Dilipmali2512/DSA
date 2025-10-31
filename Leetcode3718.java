import java.util.ArrayList;
import java.util.List;

public class Leetcode3718 {

    public static int missingMultiple(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        int m = k;
        boolean isFind = false;
        while (!isFind) {
            if (!list.contains(m)) {
                isFind = true;
            } else {
                m = m + k;
            }
        }
        return m;

    }

    public static void main(String[] args) {
        System.out.println(missingMultiple(new int[] { 8, 2, 3, 4, 6 }, 2));
    }

}