import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int SNAKE = 0;
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    private static int n, m;
    private static int[][] arr;
    private static int[][] distance;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        distance = new int[n][m];
        distance[0][0] = 0;

        start(0, 0);

        if (distance[n - 1][m - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[n - 1][m - 1]);
        }
    }

    private static void start(int startRow, int startCol) {
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        visited[startRow][startCol] = true;
        queue.add(new Point(startRow, startCol));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.x;
            int col = point.y;

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inArray(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] != SNAKE) {
                    distance[nextRow][nextCol] = distance[row][col] + 1;
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}