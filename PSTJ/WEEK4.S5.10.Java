import java.util.ArrayList;
import java.util.Scanner;

public class MatrixRotationAlgorithm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        System.out.print("Enter number of rotations: ");
        int rotations = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }

        int layers = Math.min(rows, columns) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int bottom = rows - 1 - layer;
            int left = layer;
            int right = columns - 1 - layer;

            ArrayList<Integer> elements = new ArrayList<>();

            // Top row
            for (int j = left; j <= right; j++) {
                elements.add(matrix[top][j]);
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix[i][right]);
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix[bottom][j]);
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix[i][left]);
            }

            int size = elements.size();

            int rotate = rotations % size;

            ArrayList<Integer> rotated = new ArrayList<>();

            // Left rotation
            for (int i = rotate; i < size; i++) {
                rotated.add(elements.get(i));
            }

            for (int i = 0; i < rotate; i++) {
                rotated.add(elements.get(i));
            }

            int index = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                matrix[top][j] = rotated.get(index++);
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = rotated.get(index++);
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix[bottom][j] = rotated.get(index++);
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = rotated.get(index++);
            }
        }

        System.out.println("Rotated Matrix:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}