import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2273 {

    public static List<String> removeAnagrams(String[] words) {
        int n = words.length;

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(words[i]);
        }

        for (int i = n - 1; i > 0;) {
            if (i < list.size() && bothStringAreSame(list.get(i), list.get(i - 1))) {
                list.remove(i);
            } else {
                i--;
            }
        }

        return list;
    }

    public static boolean bothStringAreSame(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        String s12 = new String(c1);
        String s13 = new String(c2);
        return s12.equals(s13);
    }

    public static void main(String[] args) {
        List<String> ans = removeAnagrams(new String[] { "abba", "baba", "bbaa", "cd", "cd" });
        for (String a : ans) {
            System.out.print(a + " ");
        }
    }
}