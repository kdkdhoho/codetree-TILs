import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int row = 1; row < n; row++) {
            dp[row][0] = dp[row - 1][0] + arr[row][0];
        }
        for (int col = 1; col < n; col++) {
            dp[0][col] = dp[0][col - 1] + arr[0][col];
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (dp[row][col] == 0) {
                    dp[row][col] = Math.max(dp[row][col - 1] + arr[row][col], dp[row - 1][col] + arr[row][col]);
                }
            }
        }
        System.out.print(dp[n - 1][n - 1]);
    }
}