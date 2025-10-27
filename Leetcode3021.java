public class Leetcode3021 {

    public static long flowerGame(int n, int m) {
        if (n == 1 || m == 1) {
            return 0;
        }
        double one = Math.floor(m / 2);
        double second = (m != 1) && (m % 2 == 0) ? one : one + 1;
        long pair = 0;
        double one1 = n == 1 ? 0 : Math.floor(n / 2);
        double second2 = n == 1 ? 1 : (n % 2 == 0) ? one1 : one1 + 1;
        pair = (long) ((second2 * one) + (second * one1));
        // for (int i = 0; i < n; i++) {
        // if (i % 2 == 0) {
        // pair += one;
        // } else {
        // pair += second;
        // }
        // }
        return pair;
    }

    public static void main(String[] args) {
        System.out.println(flowerGame(1, 5));
    }
}