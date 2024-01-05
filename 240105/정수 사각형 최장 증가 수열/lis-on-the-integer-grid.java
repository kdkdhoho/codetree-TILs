import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    private static int n, answer = Integer.MIN_VALUE;
    private static int[][] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                bfs(row, col);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        Queue<Integer> distance = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.add(new Point(row, col));
        distance.add(1);
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int currentDistance = distance.poll();

            answer = Math.max(answer, currentDistance);

            int startRow = point.x;
            int startCol = point.y;

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = startRow + dRow[d];
                int nextCol = startCol + dCol[d];

                if (inArray(nextRow, nextCol) && !visited[nextRow][nextCol] && isBigger(nextRow, nextCol, startRow, startCol)) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                    distance.add(currentDistance + 1);
                }
            }
        }
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private static boolean isBigger(int targetRow, int targetCol, int sourceRow, int sourceCol) {
        return arr[targetRow][targetCol] > arr[sourceRow][sourceCol];
    }
}