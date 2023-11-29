import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m, answer = 0;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int currV) {
        visited[currV] = true;

        for (int i = 0; i < graph.get(currV).size(); i++) {
            int nextV = graph.get(currV).get(i);
            if (!visited[nextV]) {
                visited[nextV] = true;
                answer++;
                dfs(nextV);
            }
        }
    }
}