import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};
    private static final int MAX_D = dRow.length;

    private static int n, k;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int currentRow, currentCol;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        currentRow = sc.nextInt() - 1;
        currentCol = sc.nextInt() - 1;
        // end of read

        // k번 반복하면서
        // 매번 시작 위치로부터 bfs 돌린다.
        // bfs 끝나면 visited 초기화해서 다시 이동할 수 있도록한다.
        for (int i = 0; i < k; i++) {
            visited = new boolean[n][n];
            bfs(currentRow, currentCol, arr[currentRow][currentCol]);
        }

        System.out.printf("%d %d", currentRow + 1, currentCol + 1);
    }

    private static void bfs(int startRow, int startCol, int startNumber) {
        int markedRow = n;
        int markedCol = n;
        int maxNumber = -1;

        Queue<Point> queue = new LinkedList<>();
        visited[startRow][startCol] = true;
        queue.add(new Point(startRow, startCol));
        // 시작 위치로부터 bfs 시작

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < MAX_D; d++) { // 상하좌우보면서
                int nextRow = point.x + dRow[d];
                int nextCol = point.y + dCol[d];

                if (inRange(nextRow, nextCol)
                        && notVisited(nextRow, nextCol)
                        && isLowerThan(nextRow, nextCol, startNumber)
                ) { // 격자 안인지? && 방문한 적이 없는지? && 시작위치의 값보다 작은지? 확인한다
                    int nextNumber = arr[nextRow][nextCol];
                    visited[nextRow][nextCol] = true;

                    if (nextNumber == maxNumber) {
                        if (nextRow < markedRow) { // 바라보는 행이, 기록해놓은 행보다 작다면 갱신
                            markedRow = nextRow;
                            markedCol = nextCol;
                            continue;
                        }
                        if (nextRow == markedRow && nextCol < markedCol) { // 바라보는 곳이 행은 같은데 열이 더 작다면 갱신
                            markedCol = nextCol;
                        }
                    } else if (nextNumber > maxNumber) {
                        maxNumber = nextNumber; // 기록하는 숫자 갱신
                        markedRow = nextRow;
                        markedCol = nextCol;
                    }

                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }

        if (markedRow == n || markedCol == n) {
            return;
        }
        currentRow = markedRow;
        currentCol = markedCol;
    }

    private static boolean inRange(int row, int col) {
        return row < n && col < n && row >= 0 && col >= 0;
    }

    private static boolean notVisited(int row, int col) {
        return !visited[row][col];
    }

    private static boolean isLowerThan(int row, int col, int criteriaNumber) {
        return arr[row][col] < criteriaNumber;
    }
}