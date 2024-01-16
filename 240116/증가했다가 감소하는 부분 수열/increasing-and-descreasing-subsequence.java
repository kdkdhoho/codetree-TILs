import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static int[] arr, dp;
    private static State[] states;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n];
        states = new State[n];

        Arrays.fill(dp, 1);
        states[0] = new State(false, false);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) { // 두 값이 같은 경우 pass
                    continue;
                }

                if (j == 0) { // 첫 번째 인덱스 뒤에 추가하는 경우
                    boolean isUp = isUp(arr[0], arr[i]);
                    State state = new State(false, isUp);

                    if (dp[0] + 1 > dp[i]) {
                        dp[i] = dp[0] + 1;
                        states[i] = state;
                    }
                }

                if (j != 0) { // 첫 번째 인덱스가 아닌 수열에 추가하는 경우
                    State lastState = states[j];

                    if (lastState.isSwitched) {
                        if (!lastState.isUp) { // 증가-감소 부분 수열
                            if (arr[j] > arr[i]) {
                                update(i, j, true, false);
                            }
                        }
                    }

                    if (!lastState.isSwitched) {
                        if (lastState.isUp) { // 증가 수열
                            if (arr[j] < arr[i]) { // 계속 증가 수열
                                update(i, j, false, true);
                            }

                            if (arr[j] > arr[i]) { // 증가-감소 수열로
                                update(i, j, true, false);
                            }
                        }

                        if (!lastState.isUp) { // 감소 수열
                            if (arr[j] > arr[i]) {
                                update(i, j, false, false);
                            }
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

    private static boolean isUp(int x, int y) {
        return x < y;
    }

    private static boolean canUpdate(int i, int j) {
        return dp[j] + 1 > dp[i];
    }

    private static void update(int i, int j, boolean isSwitched, boolean isUp) {
        dp[i] = dp[j] + 1;
        states[i] = new State(isSwitched, isUp);
    }
}

class State {
    boolean isSwitched;
    boolean isUp;

    public State(boolean isSwitched, boolean isUp) {
        this.isSwitched = isSwitched;
        this.isUp = isUp;
    }
}