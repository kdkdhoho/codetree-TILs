import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int ROAD = 0;
    private static final int WALL = 1;
    private static final int HUMAN = 2;
    private static final int SHELTER = 3;
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    private static int n, h, m;
    private static int[][] arr;
    private final static List<Point> humanPoints = new ArrayList<>();
    private static int[][] answerArr;

    public static void main(String[] args) {
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        answerArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                arr[i][j] = num;

                if (num == HUMAN) {
                    humanPoints.add(new Point(i, j));
                }
            }
        }

        for (Point humanPoint : humanPoints) {
            bfs(humanPoint.x, humanPoint.y);
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                sb.append(answerArr[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }

    private static void bfs(int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[][] step = new int[n][n];

        visited[startRow][startCol] = true;
        queue.add(new Point(startRow, startCol));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.x;
            int col = point.y;

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inArray(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] != WALL) {
                    step[nextRow][nextCol] = step[row][col] + 1;
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));

                    if (arr[nextRow][nextCol] == SHELTER) {
                        answerArr[startRow][startCol] = step[nextRow][nextCol];
                        return;
                    }
                }
            }
        }

        answerArr[startRow][startCol] = -1;
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}