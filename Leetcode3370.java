public class Leetcode3370 {

    public static int smallestNumber(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder news = new StringBuilder(s);
        for (int i = 0; i < news.length(); i++) {
            if (news.charAt(i) == '0') {
                news.setCharAt(i, '1');
            }
        }

        return Integer.parseInt(news.toString(), 2);
    }

    public static int smallestNumber1(int n) {
        int num = n;
        while ((num & (num + 1)) != 0) {
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber1(10));
    }
}
