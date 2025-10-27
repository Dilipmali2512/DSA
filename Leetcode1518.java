public class Leetcode1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        while (numBottles >= numExchange) {
            count += numExchange;
            numBottles -= (numExchange - 1);
        }
        return count + numBottles;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }
}
