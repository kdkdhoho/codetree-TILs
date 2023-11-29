import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {0, 1, 0, -1};
    private static final int[] dCol = {1, 0, -1, 0};
    private static final int MAX_D = dRow.length;

    private static final int HUMAN = 1;

    private static int n, peopleNum = 1;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final List<Integer> peopleNums = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (canGo(row, col)) {
                    visited[row][col] = true;
                    peopleNum = 1;
                    dfs(row, col);
                    peopleNums.add(peopleNum);
                }
            }
        }

        peopleNums.sort(Comparator.naturalOrder());
        System.out.println(peopleNums.size());
        for (Integer num : peopleNums) {
            System.out.println(num);
        }
    }

    private static boolean canGo(int row, int col) {
        return arr[row][col] == HUMAN && !visited[row][col];
    }

    private static void dfs(int row, int col) {
        for (int d = 0; d < MAX_D; d++) {
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];

            if (isInRange(nextRow, nextCol) && canGo(nextRow, nextCol)) {
                visited[nextRow][nextCol] = true;
                peopleNum++;
                dfs(nextRow, nextCol);
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return row < n && col < n && row >= 0 && col >= 0;
    }
}