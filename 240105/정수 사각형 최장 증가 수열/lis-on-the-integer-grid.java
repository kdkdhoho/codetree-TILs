import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * N*N 크기의 격자가 있다.
 * 시작점을 적절히 잡아 상하좌우 인접한 칸으로 계속 칸의 수가 큰 쪽으로 이동한다.
 * 이떄, 이동할 수 있는 최대 수는?
 * <p>
 * 각 칸에 적힌 수들 중, 가장 작은 값부터 순서대로 DP 값을 갱신한다.
 * 즉, 칸의 수들을 모두 오름차순 정렬하고, 작은 값의 칸부터 상하좌우로 보며 DP 값을 갱신한다.
 * 이때 DP는 모두 1로 초기화한다.
 */
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
        } // 입력 받음

        // 각 칸에 대한 정보(값, 행, 열)를 리스트에 수집하고 정렬한다.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                cells.add(new Cell(arr[row][col], row, col));
            }
        }
        Collections.sort(cells);

        // dp 테이블을 모두 1로 초기화한다.
        dp = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                dp[row][col] = 1;
            }
        }

        // 수집, 정렬된 Cell을 모두 보며 DP 테이블을 갱신한다.
        for (Cell cell : cells) {
            int row = cell.row();
            int col = cell.col();

            for (int d = 0; d < dRow.length; d++) {
                int nextRow = row + dRow[d];
                int nextCol = col + dCol[d];

                if (inArray(nextRow, nextCol) && isBigger(nextRow, nextCol, row, col)) {
                    dp[nextRow][nextCol] = Math.max(dp[nextRow][nextCol], dp[row][col] + 1);
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
        return this.value - o.value;
    }
}