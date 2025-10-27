import java.util.ArrayList;
import java.util.List;

public class Leetcode2125 {
    public static int numberOfBeams(String[] bank) {

        int ans = 0;
        int prev = 0;

        for (int j = 0; j < bank.length; j++) {
            String s = bank[j];
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }

            if (count != 0) {
                ans += count * prev;
                prev = count;
            }
            
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[] { "011001", "000000", "010100", "001000" }));
    }
}