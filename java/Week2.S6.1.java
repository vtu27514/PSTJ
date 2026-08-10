import java.util.Arrays;

public class ShuffleArray {

    // Function to shuffle the array
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }

        return result;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        int n1 = 3;
        System.out.println("Output: " + Arrays.toString(shuffle(nums1, n1)));

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        System.out.println("Output: " + Arrays.toString(shuffle(nums2, n2)));

        // Test Case 3
        int[] nums3 = {1, 1, 2, 2};
        int n3 = 2;
        System.out.println("Output: " + Arrays.toString(shuffle(nums3, n3)));
    }
}