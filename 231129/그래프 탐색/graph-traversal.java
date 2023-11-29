import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m, answer = 0;
    private static boolean[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new boolean[n][n];
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int currV) {
        visited[currV] = true;

        for (int nextV = 0; nextV < n; nextV++) {
            if (graph[currV][nextV] && !visited[nextV]) {
                visited[nextV] = true;
                answer++;
                dfs(nextV);
            }
        }
    }
}