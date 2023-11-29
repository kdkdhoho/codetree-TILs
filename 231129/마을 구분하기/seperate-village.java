import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] dRow = {0, 1, 0, -1};
    private static final int[] dCol = {1, 0, -1, 0};
    private static final int MAX_D = dRow.length;

    private static final int HUMAN = 1;

    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        List<Village> villages = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && arr[row][col] == HUMAN) {
                    visited[row][col] = true;
                    Village village = new Village();
                    village.addHuman();
                    dfs(row, col, village);
                    villages.add(village);
                }
            }
        }

        villages.sort(Comparator.comparing(Village::humans));

        StringBuilder answer = new StringBuilder();
        answer.append(villages.size()).append(System.lineSeparator());
        String result = villages.stream()
                .map(Village::humans)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
        answer.append(result);
        System.out.println(answer);
    }

    private static void dfs(int row, int col, Village village) {
        for (int d = 0; d < MAX_D; d++) {
            int nextRow = row + dRow[d];
            int nextCol = col + dCol[d];

            if (isInRange(nextRow, nextCol) && canGo(nextRow, nextCol)) {
                visited[nextRow][nextCol] = true;
                village.addHuman();
                dfs(nextRow, nextCol, village);
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return row < n && col < n && row >= 0 && col >= 0;
    }

    private static boolean canGo(int row, int col) {
        return arr[row][col] == HUMAN && !visited[row][col];
    }
}

class Village {

    private int humans = 0;

    public void addHuman() {
        humans++;
    }

    public int humans() {
        return humans;
    }
}