import java.util.Scanner;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int totalSum = nums[0];

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < n; i++) {

            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);

            totalSum += nums[i];
        }

        // If all elements are negative
        if (maxSum < 0) {
            System.out.println("Maximum Circular Subarray Sum = " + maxSum);
        } else {

            int circularSum = totalSum - minSum;

            int answer = Math.max(maxSum, circularSum);

            System.out.println(
                    "Maximum Circular Subarray Sum = " + answer);
        }

        sc.close();
    }
}