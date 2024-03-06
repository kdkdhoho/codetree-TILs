import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 0,1로 구성된 n*n 크기의 격자판이 있다.
 * 1은 폭탄이다.
 * <p>
 * 1이 써있는 위치에 3가지 중 하나의 폭탄을 선택해서 초토화시킬 지역의 수를 최대화하려고 한다.
 * <p>
 * 초기 격자판의 상태와 폭탄을 놓아야 할 위치들이 주어졌을 때, 최대한 많이 초토화시킬 수 있는 영역의 수를 구하시오.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] case1dRow = {-2, 1, 1, 1, 1};

    private static final int[] case2dRow = {-1, 1, 1, -1, 0};
    private static final int[] case2dCol = {0, 1, -1, -1, 1};

    private static final int[] case3dRow = {-1, 0, 2, 0, -1};
    private static final int[] case3dCol = {-1, 2, 0, -2, 1};

    private static int n, answer = Integer.MIN_VALUE;
    private static int[][] arr;
    private final static List<Point> bombPositions = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();

                if (arr[row][col] == 1) {
                    bombPositions.add(new Point(row, col));
                }
            }
        }

        simulationAllCase(0, new int[n][n]);

        System.out.println(answer);
    }

    private static void simulationAllCase(int index, int[][] simulation) {
        if (index >= bombPositions.size()) {
            int count = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (simulation[row][col] > 0) {
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        Point point = bombPositions.get(index);
        int row = point.x;
        int col = point.y;

        for (int caze = 1; caze <= 3; caze++) {
            if (caze == 1) {
                int nextRow = row;

                for (int d = 0; d < case1dRow.length; d++) {
                    nextRow += case1dRow[d];

                    if (inArray(nextRow, col)) {
                        simulation[nextRow][col]++;
                    }
                }
            }

            if (caze == 2) {
                int nextRow = row;
                int nextCol = col;

                for (int d = 0; d < case2dRow.length; d++) {
                    nextRow += case2dRow[d];
                    nextCol += case2dCol[d];

                    if (inArray(nextRow, nextCol)) {
                        simulation[nextRow][nextCol]++;
                    }
                }
            }

            if (caze == 3) {
                int nextRow = row;
                int nextCol = col;

                for (int d = 0; d < case3dRow.length; d++) {
                    nextRow += case3dRow[d];
                    nextCol += case3dCol[d];

                    if (inArray(nextRow, nextCol)) {
                        simulation[nextRow][nextCol]++;
                    }
                }
            }

            simulationAllCase(index + 1, simulation);

            if (caze == 1) {
                int nextRow = row;

                for (int d = 0; d < case1dRow.length; d++) {
                    nextRow += case1dRow[d];

                    if (inArray(nextRow, col)) {
                        simulation[nextRow][col]--;
                    }
                }
            }

            if (caze == 2) {
                int nextRow = row;
                int nextCol = col;

                for (int d = 0; d < case2dRow.length; d++) {
                    nextRow += case2dRow[d];
                    nextCol += case2dCol[d];

                    if (inArray(nextRow, nextCol)) {
                        simulation[nextRow][nextCol]--;
                    }
                }
            }

            if (caze == 3) {
                int nextRow = row;
                int nextCol = col;

                for (int d = 0; d < case3dRow.length; d++) {
                    nextRow += case3dRow[d];
                    nextCol += case3dCol[d];

                    if (inArray(nextRow, nextCol)) {
                        simulation[nextRow][nextCol]--;
                    }
                }
            }
        }
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}