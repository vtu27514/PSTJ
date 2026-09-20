import java.util.*;

public class BetweenDates {

    public static int daysBetweenDates(String date1, String date2) {

        int days1 = getDays(date1);
        int days2 = getDays(date2);

        return Math.abs(days1 - days2);
    }

    public static int getDays(String date) {

        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int total = 0;

        // Count days in previous years
        for (int y = 1971; y < year; y++) {
            if (isLeap(y)) {
                total += 366;
            } else {
                total += 365;
            }
        }

        int[] monthDays = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Count days in previous months
        for (int m = 1; m < month; m++) {
            total += monthDays[m - 1];

            // Add extra day for February in leap year
            if (m == 2 && isLeap(year)) {
                total++;
            }
        }

        // Add days in current month
        total += day;

        return total;
    }

    public static boolean isLeap(int year) {

        if (year % 400 == 0) {
            return true;
        }

        if (year % 100 == 0) {
            return false;
        }

        return year % 4 == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String date1 = sc.next();
        String date2 = sc.next();

        System.out.println(daysBetweenDates(date1, date2));

        sc.close();
    }
}