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
        } // O(N^2)

        recursive(new ArrayList<>(), new boolean[n]);
        System.out.print(answer);
    }

    private static void recursive(List<Integer> pickedColumnIndexes, boolean[] colUsed) {
        if (pickedColumnIndexes.size() == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][pickedColumnIndexes.get(i)];
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!colUsed[col]) {
                colUsed[col] = true;
                pickedColumnIndexes.add(col);
                recursive(pickedColumnIndexes, colUsed);
                colUsed[col] = false;
                pickedColumnIndexes.remove(pickedColumnIndexes.size() - 1);
            }
        }
    }
}