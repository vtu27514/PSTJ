import java.util.Scanner;

public class MatrixBlockSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                int sum = 0;

                int rowStart = Math.max(0, i - k);
                int rowEnd = Math.min(rows - 1, i + k);

                int columnStart = Math.max(0, j - k);
                int columnEnd = Math.min(columns - 1, j + k);

                for (int r = rowStart; r <= rowEnd; r++) {

                    for (int c = columnStart;
                         c <= columnEnd; c++) {

                        sum += matrix[r][c];
                    }
                }

                result[i][j] = sum;
            }
        }

        System.out.println("Matrix Block Sum:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}