import java.util.ArrayList;
import java.util.Scanner;

public class FindAndReplacePattern {

    static boolean matchesPattern(String word, String pattern) {

        if (word.length() != pattern.length()) {
            return false;
        }

        int[] wordMap = new int[256];
        int[] patternMap = new int[256];

        for (int i = 0; i < word.length(); i++) {

            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (wordMap[w] != patternMap[p]) {
                return false;
            }

            wordMap[w] = i + 1;
            patternMap[p] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter words:");

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        System.out.print("Enter pattern: ");
        String pattern = sc.next();

        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {

            if (matchesPattern(word, pattern)) {
                result.add(word);
            }
        }

        System.out.println("Matching words:");

        for (String word : result) {
            System.out.print(word + " ");
        }

        System.out.println();

        sc.close();
    }
}