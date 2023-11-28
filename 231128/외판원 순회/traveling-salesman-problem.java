import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, answer = Integer.MAX_VALUE;
    private static int[][] values;

    public static void main(String[] args) {
        n = sc.nextInt();
        values = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                values[i][j] = sc.nextInt();
            }
        }

        int start = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;

        recursive(start, visited, 0, 0);

        System.out.print(answer);
    }

    private static void recursive(int start, boolean[] visited, int sum, int cnt) {
        if (cnt == n - 1) {
            if (values[start][0] == 0) {
                return;
            }
            
            sum += values[start][0];
            answer = Math.min(answer, sum);
            return;
        }

        for (int target = 0; target < n; target++) {
            if (!visited[target] && values[start][target] != 0) {
                visited[target] = true;
                recursive(target, visited, sum + values[start][target], cnt + 1);
                visited[target] = false;
            }
        }
    }
}