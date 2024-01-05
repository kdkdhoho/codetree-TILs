import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    private static int n;
    private static int[][] arr, dp;
    private static final List<Cell> cells = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                cells.add(new Cell(arr[row][col], row, col));
            }
        }
        Collections.sort(cells);

        dp = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                dp[row][col] = 1;
            }
        }

        for (int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            int row = cell.row();
            int col = cell.col();

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inArray(nextRow, nextCol) && isBigger(nextRow, nextCol, row, col)) {
                    dp[nextRow][nextCol] = Math.max(dp[nextRow][nextCol], dp[nextRow][nextCol] + 1);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                answer = Math.max(answer, dp[row][col]);
            }
        }
        System.out.println(answer);
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    private static boolean isBigger(int targetRow, int targetCol, int sourceRow, int sourceCol) {
        return arr[targetRow][targetCol] > arr[sourceRow][sourceCol];
    }
}

class Cell implements Comparable<Cell> {

    private final int value;
    private final int row;
    private final int col;

    public Cell(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public int value() {
        return value;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    @Override
    public int compareTo(Cell o) {
        if (this.value == o.value) {
            if (this.row == o.row) {
                return this.col - o.col;
            }
            return this.row - o.row;
        }
        return this.value - o.value;
    }
}