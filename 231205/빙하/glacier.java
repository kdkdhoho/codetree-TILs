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
    private static boolean[][] changed;
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

            changed = new boolean[n][m];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (arr[row][col] == WATER && !changed[row][col]) {
                        if (isSide(row, col) || canReachSide(row, col)) {
                            melt(row, col);
                            // 사방 돌면서 1로 바꾼다.
                            // 1로 바꿀 때, changed[row][col] = true를 한다.
                            // 1로 바꿀 때, iceCount--도 해준다.
                        }
                    }
                }
            }
        }

        System.out.printf("%d %d", meltingTime, lastIceCount);
    }

    private static boolean isSide(int row, int col) {
        return row == 0 || row == n - 1 || col == 0 || col == m - 1;
    }

    private static boolean canReachSide(int startRow, int startCol) {
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

                if (inRange(nextRow, nextCol) && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == WATER && !changed[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    rowQueue.add(nextRow);
                    colQueue.add(nextCol);
                }
            }
        }

        return false;
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static void melt(int row, int col) {
        for (int d = 0; d < dRow.length; d++) {
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