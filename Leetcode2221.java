public class Leetcode2221 {

    public static int triangularSum(int[] nums) {

        int array[] = nums;

        while (array.length > 1) {
            int temp[] = new int[array.length - 1];

            for (int i = 0; i < array.length - 1; i++) {
                temp[i] = (array[i] + array[i + 1]) % 10;
            }
            array = temp;
        }

        return array[0];

    }

    public static void main(String[] args) {
        System.out.println(triangularSum(new int[] {  5 }));
    }
}