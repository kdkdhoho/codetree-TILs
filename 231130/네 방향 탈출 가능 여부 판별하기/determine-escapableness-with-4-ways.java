import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {0, 1, 0, -1};
    private static final int[] dCol = {1, 0, -1, 0};
    private static final int MAX_D = dRow.length;

    private static final int HUMAN = 1;

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
                arr[i][j] = sc.nextInt();
            }
        }

        visited[0][0] = true;
        bfs(0, 0);

        int result = visited[n - 1][m - 1] ? 1 : 0;
        System.out.print(result);
    }

    private static void bfs(int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startRow, startCol));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < MAX_D; d++) {
                int nextRow = point.x + dRow[d];
                int nextCol = point.y + dCol[d];

                if (inRange(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == HUMAN) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}