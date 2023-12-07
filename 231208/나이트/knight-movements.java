import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int NOT_MARKED = -1;
    private static final int[] dRow = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dCol = {-2, -1, 1, 2, 2, 1, -1, -2};

    private static int n;
    private static int startRow, startCol, endRow, endCol;
    private static int[][] steps;
    private static boolean canMarkNextStep = true;

    public static void main(String[] args) {
        n = sc.nextInt();
        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;
        endRow = sc.nextInt() - 1;
        endCol = sc.nextInt() - 1;

        steps = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(steps[i], NOT_MARKED);
        }
        steps[endRow][endCol] = 0;

        while (steps[startRow][startCol] == NOT_MARKED && canMarkNextStep) {
            markNextSteps();
        }
        System.out.println(steps[startRow][startRow]);
    }

    private static void markNextSteps() {
        boolean isMarked = false;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (steps[row][col] != NOT_MARKED) {
                    isMarked = mark(row, col, isMarked);
                }
            }
        }

        canMarkNextStep = isMarked;
    }

    private static boolean mark(int row, int col, boolean isMarked) {
        for (int d = 0; d < dRow.length; d++) {
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];

            if (inArray(nextRow, nextCol) && steps[nextRow][nextCol] == NOT_MARKED) {
                steps[nextRow][nextCol] = steps[row][col] + 1;
                isMarked = true;
            }
        }

        return isMarked;
    }

    private static boolean inArray(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}