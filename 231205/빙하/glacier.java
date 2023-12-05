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
    private static boolean[][] visited;
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

            visited = new boolean[n][m];

            bfs(0, 0);

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (arr[row][col] == ICE) {
                        for (int d = 0; d < dRow.length; d++) {
                            int nextRow = row + dRow[d];
                            int nextCol = col + dCol[d];

                            if (visited[nextRow][nextCol]) {
                                arr[row][col] = 0;
                                iceCount--;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.printf("%d %d", meltingTime, lastIceCount);
    }

    private static void bfs(int startRow, int startCol) {
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        visited[startRow][startCol] = true;
        rowQueue.add(startRow);
        colQueue.add(startCol);

        while (!rowQueue.isEmpty()) {
            int row = rowQueue.poll();
            int col = colQueue.poll();

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inRange(nextRow, nextCol)
                        && !visited[nextRow][nextCol]
                        && arr[nextRow][nextCol] == WATER
                ) {
                    visited[nextRow][nextCol] = true;
                    rowQueue.add(nextRow);
                    colQueue.add(nextCol);
                }
            }
        }
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}