import java.util.Scanner;

public class MaxSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Maximum contiguous subarray
        int current = arr[0];
        int maxSubarray = arr[0];

        // Maximum non-contiguous subsequence
        int maxSubsequence = arr[0];

        for (int i = 1; i < n; i++) {

            current = Math.max(arr[i], current + arr[i]);

            maxSubarray = Math.max(maxSubarray, current);

            if (arr[i] > 0) {
                maxSubsequence += arr[i];
            }
        }

        // If all numbers are negative
        if (maxSubsequence < 0) {

            maxSubsequence = arr[0];

            for (int i = 1; i < n; i++) {

                if (arr[i] > maxSubsequence) {
                    maxSubsequence = arr[i];
                }
            }
        }

        System.out.println("Maximum Subarray Sum = " + maxSubarray);
        System.out.println("Maximum Subsequence Sum = " + maxSubsequence);

        sc.close();
    }
}