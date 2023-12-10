import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 각 숫자를 노드, 연산을 간선으로 생각해보자.
 * 각 노드에서 연산을 수행했을 때 갈 수 있는 새로운 노드 사이의 가중치는 모두 같다.
 * <p>
 * 따라서 노드 N으로부터 노드 1까지의 최단거리를 구하는 문제가 되므로 BFS로 쉽게 해결 가능하다.
 * <p>
 * 이때 주의해야 할 점은 다음과 같다.
 * 노드의 범위는 1 에서 2N-1 까지 설정해야 한다는 것이다.
 * 우선 범위가 N을 넘어서는 이유로는, N보다 더 큰 수를 만들고 나누는 과정을 통해 1로 더 빠르게 도달할 수 있기 때문이다.
 * <p>
 * 그렇다면 N이 무한정 커질 수 있는데 최대 2N-1 까지만 고려해도 괜찮은 이유는 다음과 같다.
 * 숫자 N에 1 빼는 연산을 N-1하면 항상 1이다. 이 말은 즉, 최대 연산 수는 N-1번이라는 뜻이다.
 * <p>
 * 따라서 N에 N-1번 연산했을 때 만들 수 있는 가장 큰 수는, N * (N-1) = 2N - 1이기 때문이다.
 * <p>
 * 결론으로, 1부터 2N-1 까지의 범위의 숫자들로 가중치가 동일한 그래프에서의 BFS를 수행하면 해결할 수 있다.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int ADD = 0;
    private static final int SUB = 1;
    private static final int DIV2 = 2;
    private static final int DIV3 = 3;

    private static int n, answer;

    public static void main(String[] args) {
        n = sc.nextInt();
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * 2];
        int[] step = new int[n * 2];

        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int number = queue.poll();

            for (int operator = 0; operator < 4; operator++) {
                if (canOperate(number, operator)) {
                    int result = calculate(number, operator);

                    if (inRange(result) && !visited[result]) {
                        visited[result] = true;
                        queue.add(result);
                        step[result] = step[number] + 1;
                    }
                }
            }
        }

        answer = step[1];
    }

    private static boolean canOperate(int number, int operator) {
        if (operator == ADD || operator == SUB) {
            return true;
        }
        if (operator == DIV2) {
            return number % 2 == 0;
        }
        if (operator == DIV3) {
            return number % 3 == 0;
        }
        return false;
    }

    private static int calculate(int number, int operator) {
        switch (operator) {
            case ADD:
                return number + 1;
            case SUB:
                return number - 1;
            case DIV2:
                return number / 2;
            case DIV3:
                return number / 3;
        }
        throw new IllegalArgumentException();
    }

    private static boolean inRange(int number) {
        return 1 <= number && number <= 2 * n - 1;
    }
}