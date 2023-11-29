import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {0, 1, 0, -1};
    private static final int[] dCol = {1, 0, -1, 0};
    private static final int MAX_D = dRow.length;

    private static final int MOVABLE = 0;

    private static int n, k, count = 0;
    private static Point[] points;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        points = new Point[2];
        for (int i = 0; i < k; i++) {
            points[i] = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
        }

        for (Point point : points) {
            int row = point.x;
            int col = point.y;
            if (!visited[row][col]) {
                count++;
                visited[row][col] = true;
                bfs(row, col);
            }
        }

        System.out.print(count);
    }

    private static void bfs(int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startRow, startCol));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < MAX_D; d++) {
                int nextRow = point.x + dRow[d];
                int nextCol = point.y + dCol[d];

                if (inRange(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == MOVABLE) {
                    count++;
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }
}