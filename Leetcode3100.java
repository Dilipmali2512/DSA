public class Leetcode3100 {
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = 0;
        while (numBottles >= numExchange) {
            count += numExchange;
            numBottles -= (numExchange - 1);
            numExchange++;
        }
        return count + numBottles;
    }

    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(13, 6)); 
    }
}
