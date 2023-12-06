import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * n*n 격자에 각 숫자가 주어진다.
 * 이 숫자들 중 k개를 겹치지 않게 선택한다.
 * 선택한 숫자들로부터 이동할 수 있는 경우의 최대 수를 구하고자 한다.
 * 이동은 상하좌우로만 할 수 있으며 두 숫자간의 차이가 u이상 d 이하인 경우만 이동할 수 있다.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    private static int n, k, u, d;
    private static int answer = -1;
    private static int[][] arr;
    private static Point[] points;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        points = new Point[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                points[idx] = new Point(i, j);
                idx++;
            }
        }

        pickCities(new ArrayList<>(), 0);

        System.out.println(answer);
    }

    private static void pickCities(List<Point> pickedCities, int pickIdx) {
        if (pickedCities.size() == k) {
            tour(pickedCities);
            return;
        }

        if (pickIdx == points.length) {
            return;
        }

        pickedCities.add(points[pickIdx]);
        pickCities(pickedCities, pickIdx + 1);
        pickedCities.remove(pickedCities.size() - 1);
        pickCities(pickedCities, pickIdx + 1);
    }

    private static void tour(List<Point> pickedCities) {
        boolean[][] visited = new boolean[n][n];
        int moveCount = 0;
        for (Point city : pickedCities) {
            moveCount += move(city, visited);
        }

        answer = Math.max(answer, moveCount);
    }

    private static int move(Point startCity, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();

        int count = 1;
        visited[startCity.x][startCity.y] = true;
        queue.add(startCity);

        while (!queue.isEmpty()) {
            Point city = queue.poll();
            int x = city.x;
            int y = city.y;

            for (int d = 0; d < dRow.length; d++) {
                int nextX = x + dRow[d];
                int nextY = y + dCol[d];

                if (inRange(nextX, nextY)
                        && !visited[nextX][nextY]
                        && satisfyCondition(x, y, nextX, nextY)) {
                    count++;
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }

        return count;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static boolean satisfyCondition(int x, int y, int nextX, int nextY) {
        int diff = Math.abs(arr[x][y] - arr[nextX][nextY]);

        return u <= diff && diff <= d;
    }
}