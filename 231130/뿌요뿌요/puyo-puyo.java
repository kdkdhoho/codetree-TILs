import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {0, 1, 0, -1};
    private static final int[] dCol = {1, 0, -1, 0};
    private static final int MAX_D = dRow.length;

    private static int n, bombCount;
    private static boolean isChecked;
    private static int totalBombCount = 0, maxBlockSize = 0;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col]) {
                    bombCount = 1;
                    isChecked = false;
                    visited[row][col] = true;
                    dfs(row, col, arr[row][col]);
                }
            }
        }

        System.out.printf("%d %d", totalBombCount, maxBlockSize);
    }

    private static void dfs(int row, int col, int initNumber) {
        for (int d = 0; d < MAX_D; d++) {
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];

            if (inRange(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == initNumber) {
                visited[nextRow][nextCol] = true;
                bombCount++;

                if (!isChecked && bombCount >= 4) {
                    isChecked = true;
                    totalBombCount++;
                }
                maxBlockSize = Math.max(maxBlockSize, bombCount);

                dfs(nextRow, nextCol, initNumber);
            }
        }
    }

    private static boolean inRange(int row, int col) {
        return row < n && col < n && col >= 0 && row >= 0;
    }
}