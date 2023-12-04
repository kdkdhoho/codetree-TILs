import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};
    private static final int MAX_D = dRow.length;

    private static final int WATER = 0;
    private static final int ICE = 1;

    private static int n, m, lastIceCount;
    private static int[][] arr;
    private static int iceCount = 0, meltingTime = 0;
    private static boolean[][] canMeltWaters;
    private static boolean[][] changed;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == ICE) {
                    iceCount++;
                }
            }
        }
        canMeltWaters = new boolean[n][m];
        changed = new boolean[n][m];

        while (iceCount != 0) {
            initCanMeltWaters();
            initChanged();

            lastIceCount = iceCount;
            meltingTime++;

            checkCanMeltWaters();
            melt();
        }

        System.out.printf("%d %d", meltingTime, lastIceCount);
    }

    private static void initCanMeltWaters() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(canMeltWaters[i], true);
        }
    }

    private static void initChanged() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(changed[i], false);
        }
    }

    private static void checkCanMeltWaters() {
        for (int row = 2; row < n - 2; row++) {
            for (int col = 2; col < m - 2; col++) {
                if (arr[row][col] == WATER) {
                    if (canReachSide(row, col)) {
                        continue;
                    }
                    canMeltWaters[row][col] = false;
                }
            }
        }
    }

    private static boolean canReachSide(int row, int col) {
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        visited[row][col] = true;
        queue.add(new Point(row, col));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (isSide(point)) {
                return true;
            }

            for (int d = 0; d < MAX_D; d++) {
                int nextRow = point.x + dRow[d];
                int nextCol = point.y + dCol[d];

                if (inRange(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == WATER) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }

        return false;
    }

    private static boolean isSide(Point point) {
        int row = point.x;
        int col = point.y;

        return row == 0 || col == 0 || row == n - 1 || col == m - 1;
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }

    private static void melt() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (arr[row][col] == WATER && !changed[row][col] && canMeltWaters[row][col]) {
                    for (int d = 0; d < MAX_D; d++) {
                        int nextRow = row + dRow[d];
                        int nextCol = col + dCol[d];

                        if (inRange(nextRow, nextCol) && arr[nextRow][nextCol] == ICE) {
                            iceCount--;
                            changed[nextRow][nextCol] = true;
                            arr[nextRow][nextCol] = WATER;
                        }
                    }
                }
            }
        }
    }
}