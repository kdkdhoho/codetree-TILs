import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2명의 도둑이 N*N 크기 방에서 물건을 훔친다.
 * 두 도둑은 각각 하나의 행을 정하고, 해당 행에 연속한 M개의 열에 있는 물건을 훔칠 수 있다.
 * 두 도둑이 같은 행을 고를 수는 있지만, 그때 선택한 M개의 열이 겹쳐서는 안된다.
 * <p>
 * 각 칸에는 무게를 나타내는 숫자가 적혀있다.
 * 도둑 각각이 들 수 있는 최대 무게가 C이기에 두 도둑 모두가 각각 훔친 물건의 합이 C를 넘으면 안된다.
 * 만약 선택한 M개의 열의 물건들 골랐을 때 C를 넘는다면, 그 중에서도 적절히 골라 고른 물건의 무게의 합이 C를 넘지 않도록 해야 한다.
 * <p>
 * 각 물건으로부터 얻을 수 있는 가치는 '무게^2' 이다.
 * <p>
 * 이러한 조건들 속에서 두 도둑이 얻을 수 있는 가치의 최대값을 구하시오.
 */
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

        for (int col = firstCol; col < firstCol + m; col++) {
            if (col == secondCol) {
                return true;
            }
        }
        for (int col = secondCol; col < secondCol + m; col++) {
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