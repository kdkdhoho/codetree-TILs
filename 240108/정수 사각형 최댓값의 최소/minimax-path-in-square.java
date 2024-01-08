import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int col = 1; col < n; col++) {
            dp[0][col] = max(dp[0][col - 1], arr[0][col]);
        }
        for (int row = 1; row < n; row++) {
            dp[row][0] = max(dp[row - 1][0], arr[row][0]);
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = min(
                        max(dp[row - 1][col], arr[row][col]),
                        max(dp[row][col - 1], arr[row][col])
                );
            }
        }
        System.out.print(dp[n - 1][n - 1]);
    }
}