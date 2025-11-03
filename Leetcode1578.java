public class Leetcode1578 {
    public static int minCost(String colors, int[] neededTime) {
        int ans = 0;
        for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                ans += Math.min(neededTime[i], neededTime[i + 1]);
                int maxTime = Math.max(neededTime[i], neededTime[i + 1]);
                neededTime[i] = maxTime;
                neededTime[i + 1] = maxTime;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minCost("aaabbbabbbb", new int[] { 3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1 }));
    }
}
