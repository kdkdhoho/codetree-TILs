import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {0, 1, 0, -1};
    private static final int[] dCol = {1, 0, -1, 0};
    private static final int MAX_D = dRow.length;

    private static int n, m;
    private static int answerK = 0, maximumSafeArea = 0, maximumHeight = 0;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                arr[row][col] = sc.nextInt();
                maximumHeight = Math.max(maximumHeight, arr[row][col]);
            }
        }

        for (int k = 1; k <= maximumHeight; k++) {
            int safeArea = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (canGo(row, col, k)) {
                        visited[row][col] = true;
                        safeArea++;
                        dfs(row, col, k);
                    }
                }
            }

            if (safeArea > maximumSafeArea) {
                maximumSafeArea = safeArea;

                if (answerK != k) {
                    answerK = k;
                }
            }

            visited = new boolean[n][m];
        }

        System.out.printf("%d %d", answerK, maximumSafeArea);
    }

    private static void dfs(int row, int col, int k) {
        for (int d = 0; d < MAX_D; d++) {
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];

            if (isInRange(nextRow, nextCol) && canGo(nextRow, nextCol, k)) {
                visited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, k);
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return row < n && col < m && row >= 0 && col >= 0;
    }

    private static boolean canGo(int row, int col, int k) {
        return arr[row][col] > k && !visited[row][col];
    }
}