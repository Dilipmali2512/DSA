import java.util.HashSet;

public class Leetcode1733 {
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        HashSet<Integer> notCUser = new HashSet<>();

        // step-1
        for (int[] friendship : friendships) {
            boolean isComunicate = false;
            for (int l1 : languages[friendship[0] - 1]) {
                for (int l2 : languages[friendship[1] - 1]) {
                    if (l1 == l2) {
                        isComunicate = true;
                        break;
                    }
                }

                if (isComunicate) {
                    break;
                }
            }

            if (!isComunicate) {
                notCUser.add(friendship[0] - 1);
                notCUser.add(friendship[1] - 1);
            }
        }

        int minUser = languages.length;

        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int tuser : notCUser) {
                boolean isKnow = false;
                for (int l : languages[tuser]) {
                    if (l == lang) {
                        isKnow = true;
                        break;
                    }
                }

                if (!isKnow) {
                    count++;
                }

            }

            minUser = Math.min(count, minUser);
        }

        return minUser;

    }

    public static void main(String[] args) {
        System.out.println(minimumTeachings(2, new int[][] { { 1 }, { 2 }, { 1, 2 } },
                new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }));
    }
}
