public class Leetcode1526 {

    public static int minNumberOperations(int[] target) {
        int[] iniArray = new int[target.length];
        int n = target.length;
        int minValue = Integer.MAX_VALUE;
        int endIndex = n;
        int startIndex = 0;
        int ans = 0;

        while (startIndex != -1) {
            startIndex = -1;
            endIndex = n;
            for (int i = 0; i < n; i++) {
                if (target[i] - iniArray[i] != 0) {
                    if (startIndex == -1) {
                        startIndex = i;
                    }
                    minValue = Math.min(minValue, target[i] - iniArray[i]);
                } else if (startIndex != -1) {
                    endIndex = i;
                    break;
                }
            }

            if (startIndex == -1) {
                break;
            }

            ans += minValue;

            for (int i = startIndex; i < endIndex; i++) {
                iniArray[i] += minValue;
            }

        }

        return ans;
    }

    public static int minNumberOperations1(int[] target) {

        int ans = target[0];
        int n = target.length;

        for (int i = 1; i < n; i++) {
            if (target[i] > target[i - 1]) {
                ans += target[i] - target[i - 1];
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(minNumberOperations1(new int[] { 3, 1, 1, 2 }));
    }
}
