import java.util.Scanner;

public class StringToIntegerAtoi {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        int i = 0;
        int n = s.length();

        // Remove leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        // Check sign
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
        else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        long result = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            result = result * 10 + digit;

            if (sign == 1 && result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
                break;
            }

            if (sign == -1 && -result < Integer.MIN_VALUE) {
                result = (long) Integer.MAX_VALUE + 1;
                break;
            }

            i++;
        }

        result = result * sign;

        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        System.out.println("Integer value = " + result);

        sc.close();
    }
}