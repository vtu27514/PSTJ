import java.util.Scanner;

public class NaivePatternSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        int n = text.length();
        int m = pattern.length();

        boolean found = false;

        System.out.println("Pattern found at positions:");

        for (int i = 0; i <= n - m; i++) {

            int j;

            for (j = 0; j < m; j++) {

                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {

                System.out.print(i + " ");

                found = true;
            }
        }

        if (!found) {
            System.out.print("Pattern not found");
        }

        System.out.println();

        sc.close();
    }
}