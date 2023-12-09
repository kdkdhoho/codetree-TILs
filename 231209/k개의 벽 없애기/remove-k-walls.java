import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int ROAD = 0;
    private static final int WALL = 1;
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    private static int n, k, minimumTime = Integer.MAX_VALUE;
    private static final List<Point> wallPoints = new ArrayList<>();
    private static Point startPoint, endPoint;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int number = sc.nextInt();
                arr[row][col] = number;

                if (number == WALL) {
                    wallPoints.add(new Point(row, col));
                }
            }
        }

        startPoint = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
        endPoint = new Point(sc.nextInt() - 1, sc.nextInt() - 1);

        removeWalls(0, 0, arr);

        int answer = -1;
        if (minimumTime != Integer.MAX_VALUE) {
            answer = minimumTime;
        }
        System.out.println(answer);
    }

    private static void removeWalls(int removeCount, int removeIndex, int[][] arr) {
        if (removeCount == k) {
            move(arr);
            return;
        }

        if (removeIndex == wallPoints.size()) {
            return;
        }

        Point point = wallPoints.get(removeIndex);
        arr[point.x][point.y] = ROAD;
        removeWalls(removeCount + 1, removeIndex + 1, arr);
        arr[point.x][point.y] = WALL;
        removeWalls(removeCount, removeIndex + 1, arr);
    }

    private static void move(int[][] arr) {
        boolean[][] visited = new boolean[n][n];
        int[][] steps = new int[n][n];
        Queue<Point> queue = new LinkedList<>();

        visited[startPoint.x][startPoint.y] = true;
        queue.add(startPoint);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.x;
            int col = point.y;

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inArray(nextRow, nextCol)
                        && !visited[nextRow][nextCol]
                        && arr[nextRow][nextCol] == ROAD
                ) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                    steps[nextRow][nextCol] = steps[row][col] + 1;

                    if (steps[endPoint.x][endPoint.y] != 0) {
                        minimumTime = Math.min(minimumTime, steps[endPoint.x][endPoint.y]);
                        return;
                    }
                }
            }
        }
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}