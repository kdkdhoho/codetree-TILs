import java.util.Arrays;
import java.util.Scanner;

/**
 * 1부터 m까지 적힌 윷놀이 판이 있다.
 * 초기엔 k개의 말이 1번 지점에 있다.
 * n번의 턴이 주어지고 각 턴마다 숫자가 주어진다. 각 턴마다 말 하나를 선택해서 숫자만큼 앞으로 이동할 수 있다.
 * 말은 앞으로 이동할 때 한 칸 단위로 이동한다. 이때, 이동하던 말이 m에 도달하면 1점을 얻는다.
 * m에 도달한 말을 또 선택할 수는 있지만, 이때는 아무 변화가 나타나지 않는다.
 * <p>
 * n번의 턴에 대해 움직일 말을 적절히 선택해서, 점수를 최대한으로 얻어라.
 * <p>
 * 각 경우에 대해서, 모든 말을 선택하기
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m, k;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        n = sc.nextInt(); // 턴
        m = sc.nextInt(); // 윷놀이 판 끝
        k = sc.nextInt(); // 말 개수
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = sc.nextInt();
        }
        int[] positions = new int[k];
        Arrays.fill(positions, 1);
        
        recursive(positions, dist, 0);

        System.out.println(answer);
    }

    private static void recursive(int[] positions, int[] dist, int cnt) {
        if (cnt == n) {
            int result = 0;
            for (int position : positions) {
                if (position >= m) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
            return;
        }

        for (int obj = 0; obj < k; obj++) {
            positions[obj] += dist[cnt];
            recursive(positions, dist, cnt + 1);
            positions[obj] -= dist[cnt];
        }
    }
}