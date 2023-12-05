import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, 1, -1};

    private static final int ICE = 1;
    private static final int WATER = 0;

    private static int n, m;
    private static int[][] arr;
    private static boolean[][] canMelt;
    private static int meltingTime = 0, lastIceCount = 0, iceCount = 0;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                arr[row][col] = sc.nextInt();
                if (arr[row][col] == ICE) {
                    iceCount++;
                }
            }
        } // end of read

        while (iceCount != 0) {
            meltingTime++;
            lastIceCount = iceCount;
            canMelt = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(canMelt[i], true);
            }

            checkCanMeltWater();
            melt();
        }

        System.out.printf("%d %d", meltingTime, lastIceCount);
    }

    private static void checkCanMeltWater() {
        for (int row = 2; row < n - 2; row++) {
            for (int col = 2; col < m - 2; col++) {
                if (arr[row][col] == WATER) {
                    if (connectToSide(row, col)) {
                        continue;
                    }
                    canMelt[row][col] = false;
                }
            }
        }
    }

    private static boolean connectToSide(int startRow, int startCol) {
        boolean[][] visited = new boolean[n][m];
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        visited[startRow][startCol] = true;
        rowQueue.add(startRow);
        colQueue.add(startCol);

        while (!rowQueue.isEmpty()) {
            int row = rowQueue.poll();
            int col = colQueue.poll();

            if (isSide(row, col)) {
                return true;
            }

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inRange(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == WATER) {
                    visited[nextRow][nextCol] = true;
                    rowQueue.add(nextRow);
                    colQueue.add(nextCol);
                }
            }
        }

        return false;
    }

    private static boolean isSide(int row, int col) {
        return row == 0 || row == n - 1 || col == 0 || col == m - 1;
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static void melt() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (arr[row][col] == WATER && canMelt[row][col]) {
                    for (int d = 0; d < dRow.length; d++) {
                        int nextRow = row + dRow[d];
                        int nextCol = col + dCol[d];

                        if (inRange(nextRow, nextCol) && arr[nextRow][nextCol] == ICE) {
                            iceCount--;
                            canMelt[nextRow][nextCol] = false;
                            arr[nextRow][nextCol] = WATER;
                        }
                    }
                }
            }
        }
    }
}