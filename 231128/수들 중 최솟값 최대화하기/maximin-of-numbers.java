import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, answer = Integer.MIN_VALUE;
    private static int[][] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        recursive(new ArrayList<>(), new boolean[n]);

        System.out.println(answer);
    }

    private static void recursive(List<Integer> columnIndexes, boolean[] used) {
        if (columnIndexes.size() == n) {
            int minimumNumber = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int number = arr[i][columnIndexes.get(i)];
                minimumNumber = Math.min(minimumNumber, number);
            }
            answer = Math.max(answer, minimumNumber);
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                columnIndexes.add(i);
                recursive(columnIndexes, used);
                columnIndexes.remove(columnIndexes.size() - 1);
                used[i] = false;
            }
        }
    }
}