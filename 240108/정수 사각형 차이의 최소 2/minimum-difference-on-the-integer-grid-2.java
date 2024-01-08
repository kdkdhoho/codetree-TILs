import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, answer = Integer.MAX_VALUE;
    private static int[][] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        for (int lowerBound = 1; lowerBound <= 100; lowerBound++) {
            int upperBound = solve(lowerBound);

            if (upperBound == Integer.MAX_VALUE) {
                continue;
            }
            answer = min(answer, upperBound - lowerBound);
        }
        System.out.print(answer);
    }

    private static int solve(int lowerBound) {
        int[][] dp = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (arr[row][col] < lowerBound) {
                    arr[row][col] = Integer.MAX_VALUE;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                dp[row][col] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = arr[0][0];
        for (int row = 1; row < n; row++) {
            dp[row][0] = max(dp[row - 1][0], arr[row][0]);
        }
        for (int col = 1; col < n; col++) {
            dp[0][col] = max(dp[0][col - 1], arr[0][col]);
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = max(
                        min(dp[row - 1][col], dp[row][col - 1]),
                        arr[row][col]
                );
            }
        }

        return dp[n - 1][n - 1];
    }
}