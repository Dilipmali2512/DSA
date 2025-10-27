import java.util.ArrayList;
import java.util.List;

public class Leetcode2785 {
    public static String sortVowels(String s) {
        int array[] = new int[128];
        List<Integer> indexArray = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                    || s.charAt(i) == 'O'
                    || s.charAt(i) == 'U') {
                array[s.charAt(i)]++;
                indexArray.add(i);
            }
            ans.append(s.charAt(i));

        }

        for (int i = 65; i < 128; i++) {
            if (array[i] != 0) {
                for (int j = 0; j < array[i]; j++) {
                    int index = indexArray.remove(0);
                    ans.setCharAt(index, (char) i);
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortVowels("axRukCyOHm"));
    }
}
