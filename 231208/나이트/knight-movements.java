import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 시작점으로부터 8방향을 BFS 한다.
 * 큐에 넣는 조건: 격자 내부, 거리가 기록되지 않음
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int NOT_MARKED = -1;
    private static final int[] dRow = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dCol = {-2, -1, 1, 2, 2, 1, -1, -2};

    private static int n;
    private static int startRow, startCol, endRow, endCol;
    private static int[][] steps;

    public static void main(String[] args) {
        n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            System.exit(0);
        }
        
        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;
        endRow = sc.nextInt() - 1;
        endCol = sc.nextInt() - 1;
        steps = new int[n][n];

        bfs(startRow, startCol);

        int answer = -1;
        if (steps[endRow][endCol] != 0) {
            answer = steps[endRow][endCol];
        }
        System.out.println(answer);
    }

    private static void bfs(int startRow, int startCol) {
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        rowQueue.add(startRow);
        colQueue.add(startCol);

        while (!rowQueue.isEmpty()) {
            int row = rowQueue.poll();
            int col = colQueue.poll();

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inArray(nextRow, nextCol) && steps[nextRow][nextCol] == 0) {
                    steps[nextRow][nextCol] = steps[row][col] + 1;
                    rowQueue.add(nextRow);
                    colQueue.add(nextCol);

                    if (nextRow == endRow && nextCol == endCol) {
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