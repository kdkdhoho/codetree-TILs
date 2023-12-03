import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final int STONE = 1;
    private static final int MOVABLE = 0;

    private static int n, k, m;
    private static int[][] arr;
    private static Point[] startPoints;
    private static final List<Point> stonePoints = new ArrayList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == STONE) {
                    stonePoints.add(new Point(i, j));
                }
            }
        }

        startPoints = new Point[k];
        for (int i = 0; i < k; i++) {
            startPoints[i] = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
        } // end of read

        removeStone(0, copyArray(arr), 0);

        System.out.println(answer);
    }

    private static int[][] copyArray(int[][] src) {
        int[][] result = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = src[row][col];
            }
        }
        return result;
    }

    private static void removeStone(int removeCount, int[][] arr, int removeStoneIdx) {
        if (removeCount == m) {
            bfs(arr);
            return;
        }

        if (removeStoneIdx == stonePoints.size()) {
            return;
        }

        // 선택했을 때
        Point point = stonePoints.get(removeStoneIdx);
        arr[point.x][point.y] = MOVABLE;
        removeStone(removeCount + 1, arr, removeStoneIdx + 1);
        arr[point.x][point.y] = STONE;

        // 선택 X
        removeStone(removeCount, arr, removeStoneIdx + 1);
    }

    private static void bfs(int[][] arr) {
        int moveCount = 0;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr.length];

        for (Point startPoint : startPoints) {
            queue.add(startPoint);
            visited[startPoint.x][startPoint.y] = true;
            moveCount++;
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = point.x + dRow[d];
                int nextCol = point.y + dCol[d];

                if (inRange(nextRow, nextCol)
                        && !visited[nextRow][nextCol]
                        && arr[nextRow][nextCol] == MOVABLE
                ) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                    moveCount++;
                }
            }
        }

        answer = Math.max(answer, moveCount);
    }

    private static boolean inRange(int row, int col) {
        return row < n && col < n && row >= 0 && col >= 0;
    }
}