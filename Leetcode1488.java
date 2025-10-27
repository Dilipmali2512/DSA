import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1488 {

    public static int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> lake = new HashMap<>();
        PriorityQueue<Integer> dry = new PriorityQueue<>();
        int ans[] = new int[rains.length];
        // 1,2,0,0,2,1
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dry.add(i);
            } else if (lake.containsKey(rains[i]) && lake.get(rains[i]) != -1) {
                int index = iCanDryOrNot(dry, lake.get(rains[i]), i);
                if (index != -1) {
                    lake.put(rains[i], i);
                    ans[index] = rains[i];
                    ans[i] = -1;
                } else {
                    return new int[] {};
                }
            } else {
                ans[i] = -1;
                lake.put(rains[i], i);
            }
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i] == 0 ? 1 : ans[i];
        }

        return ans;
    }

    public static int iCanDryOrNot(PriorityQueue<Integer> dry, int index1, int index2) {
        int isDry = -1;
        for (int num : dry) {
            if (num > index1) {
                dry.remove(num);
                isDry = num;
                break;
            }
        }

        return isDry;
    }

    public static void main(String[] args) {
        int ans[] = avoidFlood(new int[] { 1, 2, 0, 1, 2 });
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
