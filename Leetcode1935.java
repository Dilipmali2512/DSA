public class Leetcode1935 {

    public static int canBeTypedWords(String text, String brokenLetters) {

        String[] words = text.split(" ");
        int count = 0;

        // System.out.println(words);
        for (String word : words) {
            for (int i = 0; i < brokenLetters.length(); i++) {
                System.out.println(word.indexOf(brokenLetters.charAt(i) + ""));
                if (word.indexOf(brokenLetters.charAt(i) + "") != -1) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(words.length);

        return words.length - count;
    }

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("leet code", "lt"));;
    }
}
