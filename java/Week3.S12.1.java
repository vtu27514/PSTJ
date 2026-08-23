import java.util.*;

public class DateoftheYear {

    public static int dayOfYear(String date) {

        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Add one day to February in a leap year
        if (isLeapYear(year)) {
            days[1] = 29;
        }

        int result = 0;

        // Add days from previous months
        for (int i = 0; i < month - 1; i++) {
            result += days[i];
        }

        // Add days in current month
        result += day;

        return result;
    }

    public static boolean isLeapYear(int year) {

        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String date = sc.nextLine();

        System.out.println(dayOfYear(date));

        sc.close();
    }
}