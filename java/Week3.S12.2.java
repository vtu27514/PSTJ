import java.util.*;

public class DateofWeek {

    public static String dayOfTheWeek(int day, int month, int year) {

        String[] days = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        };

        int totalDays = 0;

        // Count days from 1971 to the previous year
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        int[] monthDays = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Count days in previous months
        for (int m = 1; m < month; m++) {
            totalDays += monthDays[m - 1];
        }

        // Add leap day for February
        if (month > 2 && isLeapYear(year)) {
            totalDays++;
        }

        // Add days before the given day
        totalDays += day - 1;

        // January 1, 1971 was Friday (index 5)
        return days[(totalDays + 5) % 7];
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.println(dayOfTheWeek(day, month, year));

        sc.close();
    }
}