import java.util.Scanner;

public class TheBirthdayBar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolate pieces: ");
        int n = sc.nextInt();

        int[] chocolate = new int[n];

        System.out.println("Enter chocolate values:");

        for (int i = 0; i < n; i++) {
            chocolate[i] = sc.nextInt();
        }

        System.out.print("Enter required sum (d): ");
        int d = sc.nextInt();

        System.out.print("Enter required length (m): ");
        int m = sc.nextInt();

        int count = 0;

        for (int i = 0; i <= n - m; i++) {

            int sum = 0;

            for (int j = i; j < i + m; j++) {
                sum += chocolate[j];
            }

            if (sum == d) {
                count++;
            }
        }

        System.out.println("Number of ways = " + count);

        sc.close();
    }
}