import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {1, 0};
    private static final int[] dCol = {0, 1};
    private static final int D_SIZE = 2;

    private static int n, m;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt(); // 1: 뱀이 없다. 0: 뱀이 있다
            }
        }

        int row = 0;
        int col = 0;
        visited[row][col] = true;

        dfs(row, col);

        System.out.println(0);
    }

    private static void dfs(int row, int col) {
        if (row == n - 1 && col == m - 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int d = 0; d < D_SIZE; d++) {
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];

            if (isInRange(nextRow, nextCol)) {
                if (canGo(nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    dfs(nextRow, nextCol);
                }
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static boolean canGo(int row, int col) {
        return arr[row][col] == 1 && !visited[row][col];
    }
}