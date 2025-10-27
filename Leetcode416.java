public class Leetcode416 {

    public static boolean isPartitionOrNot(int sum, int index, int array[], int targetSum) {
        if (index >= array.length) {
            return false;
        }

        if (sum == targetSum) {
            return true;
        }

        boolean isAdd = isPartitionOrNot(sum + array[index], index + 1, array, targetSum);
        boolean notAdd = isPartitionOrNot(sum, index + 1, array, targetSum);

        return isAdd || notAdd;
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return isPartitionOrNot(0, 0, nums, sum / 2);
    }

    public static void main(String[] args) {

    }
}
