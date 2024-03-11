import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {0, 1, 0, -1};
    private static final int[] dCol = {1, 0, -1, 0};

    private static int arrRow, arrCol;
    private static int[][] arr;
    private static int[][] isColored;

    public static void main(String[] args) {
        arrRow = sc.nextInt();
        arrCol = sc.nextInt();
        arr = new int[arrRow][arrCol];
        for (int row = 0; row < arrRow; row++) {
            for (int col = 0; col < arrCol; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        isColored = new int[arrRow][arrCol];
        for (int row = 0; row < arrRow; row++) {
            for (int col = 0; col < arrCol; col++) {
                isColored[row][col] = sc.nextInt();
            }
        }

        int[][] dp = new int[arrRow][arrCol];
        for (int row = 0; row < arrRow; row++) {
            for (int col = 0; col < arrCol; col++) {
                dp[row][col] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int row = 0; row < arrRow; row++) {
            for (int col = 0; col < arrCol; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nextRow = row + dRow[d];
                    int nextCol = col + dCol[d];

                    if (inArray(nextRow, nextCol)) {
                        int gap = Math.abs(arr[row][col] - arr[nextRow][nextCol]);
                        dp[row][col] = Math.min(dp[row][col], gap);
                    }
                }
            }
        }

        int answer = 0;
        for (int row = 0; row < arrRow; row++) {
            for (int col = 0; col < arrCol; col++) {
                if (isColored[row][col] == 1) {
                    answer = Math.max(answer, dp[row][col]);
                }
            }
        }
        System.out.print(answer);
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < arrRow && col >= 0 && col < arrCol;
    }
}