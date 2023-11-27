import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, answer = Integer.MIN_VALUE;
    private static int[][] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        } // O(N^2)

        recursive(0, 0, new boolean[n], new boolean[n]);
        System.out.print(answer);
    }

    private static void recursive(int pickCount, int sum, boolean[] rowUsed, boolean[] colUsed) {
        if (pickCount == n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!rowUsed[row]) {
                for (int col = 0; col < n; col++) {
                    if (!colUsed[col]) {
                        rowUsed[row] = true;
                        colUsed[col] = true;
                        recursive(pickCount + 1, sum + arr[row][col], rowUsed, colUsed);
                        rowUsed[row] = false;
                        colUsed[col] = false;
                    }
                }
            }
        }
    }
}