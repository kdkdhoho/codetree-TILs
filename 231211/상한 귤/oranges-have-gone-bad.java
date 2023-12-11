import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};
    private static final int EMPTY = 0;
    private static final int MANDARIN = 1;
    private static final int SPOILED_MANDARIN = 2;

    private static int n, k;
    private static int[][] arr;

    private static final Queue<Point> queue = new LinkedList<>();
    private static boolean[][] visited;
    private static int[][] step;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        step = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();

                if (arr[row][col] == SPOILED_MANDARIN) {
                    visited[row][col] = true;
                    queue.add(new Point(row, col));
                }
            }
        }

        while (!queue.isEmpty()) {
            final Point point = queue.poll();
            int row = point.x;
            int col = point.y;

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inArray(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == MANDARIN) {
                    step[nextRow][nextCol] = step[row][col] + 1;
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (arr[row][col] == MANDARIN && !visited[row][col]) {
                    System.out.print(-2 + " ");
                    continue;
                }
                if (arr[row][col] == EMPTY) {
                    System.out.print(-1 + " ");
                    continue;
                }
                System.out.print(step[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}