import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, k, u, d, answer = -1;
    private static int[][] arr;

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

        choiceCities(new ArrayList<>(), new ArrayList<>(), new boolean[n][n], 0, 0);

        System.out.print(answer);
    }

    private static void choiceCities(List<Integer> pickCityRows, List<Integer> pickCityCols, boolean[][] choose, int row, int col) {
        if (pickCityRows.size() == k) {
            tour(pickCityRows, pickCityCols);
            return;
        }

        if (!inRange(row, col)) {
            return;
        }

        // 선택했을 때
        pickCityRows.add(row);
        pickCityCols.add(col);
        choose[row][col] = true;

        choiceCities(pickCityRows, pickCityCols, choose, row, col + 1);
        choiceCities(pickCityRows, pickCityCols, choose, row + 1, col);
        choiceCities(pickCityRows, pickCityCols, choose, row + 1, col + 1);

        pickCityRows.remove(pickCityRows.size() - 1);
        pickCityCols.remove(pickCityCols.size() - 1);
        choose[row][col] = false;

        // 선택하지 않았을 때
        choiceCities(pickCityRows, pickCityCols, choose, row, col + 1);
        choiceCities(pickCityRows, pickCityCols, choose, row + 1, col);
        choiceCities(pickCityRows, pickCityCols, choose, row + 1, col + 1);
    }

    private static void tour(List<Integer> pickCityRows, List<Integer> pickCityCols) {
        int tourCount = 0;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < pickCityRows.size(); i++) {
            int row = pickCityRows.get(i);
            int col = pickCityCols.get(i);

            if (!visited[row][col]) {
                tourCount += move(row, col, visited);
            }
        }

        answer = Math.max(answer, tourCount);
    }

    private static int move(int startRow, int startCol, boolean[][] visited) {
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        int count = 1;
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

                if (inRange(nextRow, nextCol) && !visited[nextRow][nextCol] && canMove(row, col, nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    count++;
                    rowQueue.add(nextRow);
                    colQueue.add(nextCol);
                }
            }
        }

        return count;
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    private static boolean canMove(int row, int col, int nextRow, int nextCol) {
        int diff = Math.abs(arr[row][col] - arr[nextRow][nextCol]);

        return u <= diff && diff <= d;
    }
}