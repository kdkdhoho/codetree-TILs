import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Scanner;

/**
 * n*n 크기 격자가 있다.
 * 0,0에서 n,n까지 가는 동안 오른쪽 혹은 밑으로만 이동한다.
 * 이때, 거쳐간 위치에 적힌 숫자 중에서 |최댓값 - 최솟값| 을 최소로 만들어라.
 * 즉, 거친 숫자들 중에서 최댓값과 최솟값의 차이를 가장 작게 만들어라
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        Cell[][] dp = new Cell[n][n];
        dp[0][0] = new Cell(arr[0][0], arr[0][0]);

        for (int col = 1; col < n; col++) {
            int max = max(dp[0][col - 1].max(), arr[0][col]);
            int min = min(dp[0][col - 1].min(), arr[0][col]);
            dp[0][col] = new Cell(max, min);
        }
        for (int row = 1; row < n; row++) {
            int max = max(dp[row - 1][0].max(), arr[row][0]);
            int min = min(dp[row - 1][0].min(), arr[row][0]);
            dp[row][0] = new Cell(max, min);
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                int maxA = max(dp[row - 1][col].max(), arr[row][col]);
                int minA = min(dp[row - 1][col].min(), arr[row][col]);
                Cell cellA = new Cell(maxA, minA);

                int maxB = max(dp[row][col - 1].max(), arr[row][col]);
                int minB = min(dp[row][col - 1].min(), arr[row][col]);
                Cell cellB = new Cell(maxB, minB);

                int diffA = cellA.diff();
                int diffB = cellB.diff();

                if (diffA < diffB) {
                    dp[row][col] = cellA;
                } else if (diffA > diffB) {
                    dp[row][col] = cellB;
                } else {
                    if (cellA.max() == cellB.max()) {
                        if (cellA.min() > cellB.min()) {
                            dp[row][col] = cellA;
                        } else if (cellA.min() < cellB.min()) {
                            dp[row][col] = cellB;
                        } else {
                            dp[row][col] = cellA;
                        }
                    } else {
                        if (cellA.max() < cellB.max()) {
                            dp[row][col] = cellA;
                        } else if (cellA.max() > cellB.max()) {
                            dp[row][col] = cellB;
                        } else {
                            dp[row][col] = cellA;
                        }
                    }
                }
            }
        }

        System.out.println(dp[n - 1][n - 1].diff());
    }
}

class Cell {
    private final int max;
    private final int min;

    public Cell(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public int diff() {
        return max - min;
    }

    public int max() {
        return max;
    }

    public int min() {
        return min;
    }
}