import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, answer = Integer.MIN_VALUE;
    private static int[][] arr;
    private static boolean[] rowUsed;
    private static boolean[] colUsed;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rowUsed = new boolean[n];
        colUsed = new boolean[n];

        recursive(0, 0);
        System.out.print(answer);
    }

    private static void recursive(int pickCount, int sum) {
        if (pickCount == n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (rowUsed[row] || colUsed[col]) {
                    continue;
                }

                rowUsed[row] = true;
                colUsed[col] = true;
                recursive(pickCount + 1, sum + arr[row][col]);
                rowUsed[row] = false;
                colUsed[col] = false;
            }
        }
    }
}