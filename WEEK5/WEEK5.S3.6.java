import java.util.Scanner;

public class AlternatingCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.print("Enter string: ");
            String s = sc.next();

            int deletions = 0;

            for (int i = 1; i < s.length(); i++) {

                if (s.charAt(i) == s.charAt(i - 1)) {
                    deletions++;
                }
            }

            System.out.println("Minimum deletions = " + deletions);
        }

        sc.close();
    }
}