import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetcode3318 {

    public static class Pair {

        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int count[] = new int[51];

            for (int j = i; j < k + i; j++) {
                count[nums[j]]++;
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.value == b.value)
                    return b.key - a.key;
                return b.value - a.value;
            });
            for (int j = 0; j < count.length; j++) {

                pq.add(new Pair(j, count[j]));
            }

            int temp = 0;

            while (temp < x) {
                ans[i] += pq.peek().key * pq.poll().value;
                temp++;
            }

        }
        return ans;
    }

    public static int[] findXSum1(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            ans[i] = helper(i, i + k, nums, x);
        }
        return ans;
    }

    public static int helper(int start, int end, int[] nums, int x) {
        int distinct = 0;
        int fre[] = new int[51];
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
            if (fre[nums[i]] == 0) {
                distinct++;
                fre[nums[i]] += 1;
            } else {
                fre[nums[i]] += 1;
            }

        }

        if (distinct < x) {
            return sum;
        }

        int temp = 0;
        int ans = 0;

        while (temp < x) {
            int bestFre = 0;
            int bestFreNum = 0;

            for (int i = 50; i >= 1; i--) {
                if (bestFre < fre[i]) {
                    bestFre = fre[i];
                    bestFreNum = i;
                }
            }
            fre[bestFreNum]=0;
            ans += bestFre * bestFreNum;
            temp++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans[] = findXSum1(new int[] { 3, 8, 7, 8, 7, 5 }, 2, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
