import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m, c, maxValue = Integer.MIN_VALUE;
    private static int[][] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        selectRows(new ArrayList<>());
        System.out.println(maxValue);
    }

    private static void selectRows(List<Integer> selectedRows) {
        if (selectedRows.size() >= 2) {
            selectCols(selectedRows, new ArrayList<>());
            return;
        }

        for (int row = 0; row < n; row++) {
            selectedRows.add(row);
            selectRows(selectedRows);
            selectedRows.remove(selectedRows.size() - 1);
        }
    }

    private static void selectCols(List<Integer> selectedRows, List<Integer> selectedCols) {
        if (selectedCols.size() >= 2) {
            if (isOverlap(selectedRows, selectedCols)) {
                return;
            }

            int value = calculateValue(selectedRows, selectedCols);
            maxValue = Math.max(maxValue, value);
            return;
        }

        for (int col = 0; col <= n - m; col++) {
            selectedCols.add(col);
            selectCols(selectedRows, selectedCols);
            selectedCols.remove(selectedCols.size() - 1);
        }
    }

    private static boolean isOverlap(List<Integer> rows, List<Integer> cols) {
        int firstRow = rows.get(0);
        int secondRow = rows.get(1);

        if (firstRow != secondRow) {
            return false;
        }

        int firstCol = cols.get(0);
        int secondCol = cols.get(1);

        for (int col = firstCol; col <= firstCol + m; col++) {
            if (col == secondCol) {
                return true;
            }
        }
        for (int col = secondCol; col <= secondCol + m; col++) {
            if (col == firstCol) {
                return true;
            }
        }
        return false;
    }

    private static int calculateValue(List<Integer> rows, List<Integer> cols) {
        Point firstPoint = new Point(rows.get(0), cols.get(0));
        Point secondPoint = new Point(rows.get(1), cols.get(1));

        int firstBlockTotalValue = calculateBlock(firstPoint);
        int secondBlockTotalValue = calculateBlock(secondPoint);

        return firstBlockTotalValue + secondBlockTotalValue;
    }

    private static int calculateBlock(Point point) {
        int weight = 0;
        int value = 0;

        int row = point.x;
        int startCol = point.y;
        for (int col = startCol; col < startCol + m; col++) {
            weight += arr[row][col];
            value += (arr[row][col] * arr[row][col]);
        }

        if (weight > c) {
            List<Integer> choicableCols = new ArrayList<>();
            for (int col = startCol; col < startCol + m; col++) {
                choicableCols.add(col);
            }
            return selectObject(0, row, choicableCols, new ArrayList<>(), Integer.MIN_VALUE);
        }
        return value;
    }

    private static int selectObject(int index, int row, List<Integer> choicableCols, List<Integer> chooseCols, int maxValue) {
        if (index >= choicableCols.size()) {
            if (choicableCols.size() == chooseCols.size()) {
                return maxValue;
            }

            int weight = 0;
            int value = 0;
            for (Integer col : chooseCols) {
                weight += arr[row][col];
                value += (arr[row][col] * arr[row][col]);
            }
            if (weight > c) {
                return maxValue;
            }
            maxValue = Math.max(maxValue, value);
            return maxValue;
        }

        // 선택했을 때
        int col = choicableCols.get(index);
        chooseCols.add(col);
        int value1 = selectObject(index + 1, row, choicableCols, chooseCols, maxValue);
        maxValue = Math.max(maxValue, value1);

        chooseCols.remove(chooseCols.size() - 1);

        int value2 = selectObject(index + 1, row, choicableCols, chooseCols, maxValue);
        maxValue = Math.max(maxValue, value2);
        return maxValue;
    }
}