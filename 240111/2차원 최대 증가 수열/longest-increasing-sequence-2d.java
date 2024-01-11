import java.util.Scanner;

/**
 * n*m 크기의 직사각형의 각 칸에 1부터 10000 사이의 수가 주어진다.
 * (0, 0) 부터 출발한다고 했을 때, 특정 룰을 만족하며 밟을 수 있는 최대 칸의 수는?
 * <p>
 * [특정 룰]
 * 1. 현재 위치에서 적어도 한 칸 이상 오른쪽에 있으며, 동시에 적어도 한 칸 이상 아래에 있는 위치로만 이동이 가능하다.
 * 2. 이동 시, 현재 위치의 숫자보다 이동하려는 위치의 숫자가 더 커야한다.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m, answer = Integer.MIN_VALUE;
    private static int[][] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (arr[row][col] > arr[0][0]) {
                    dp[row][col]++;
                }
            }
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (dp[row][col] == 0) {
                    continue;
                }

                mark(row, col, dp);

                answer = Math.max(answer, dp[row][col]);
            }
        }
        System.out.println(answer + 1);
    }

    private static void mark(int startRow, int startCol, int[][] dp) {
        for (int row = startRow + 1; row < n; row++) {
            for (int col = startCol + 1; col < m; col++) {
                if (arr[row][col] > arr[startRow][startCol]) {
                    dp[row][col] = Math.max(dp[row][col], dp[startRow][startCol] + 1);
                }
            }
        }
    }
}