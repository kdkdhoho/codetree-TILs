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

                    if (lastState.isSwitched) { // 마지막 상태가 바뀐 적이 있는 경우
                        if (lastState.isUp) { // 바뀐 적이 있는 증가 수열인 경우
                            if (arr[i] > arr[j]) { // 바뀐 적이 있고 증가 수열에 그대로 증가인 경우
                                if (canUpdate(i, j)) {
                                    update(i, j, true, true);
                                }
                            }
                            if (arr[i] < arr[j]) { // 바뀐 적이 있고 증가 수열에 감소하는 수가 추가되는 경우
                                // nothing
                            }
                        }

                        if (!lastState.isUp) { // 바뀐 적이 있는 감소 수열인 경우
                            if (arr[i] > arr[j]) { // 바뀐 적이 있고 감소 수열에 추가했을 때 증가하는 경우
                                // nothing
                            }
                            if (arr[i] < arr[j]) { // 바뀐 적이 있고 감수 수열에 추가했을 때 그대로 감소하는 경우
                                if (canUpdate(i, j)) {
                                    update(i, j, true, false);
                                }
                            }
                        }
                    }

                    if (!lastState.isSwitched) { // 바뀐 적이 없는 경우
                        if (lastState.isUp) { // 바뀐 적이 없는 증가 수열인 경우
                            if (arr[i] > arr[j]) { // 바뀐 적이 없는 증가 수열에 추가했을 때 그대로 증가하는 경우
                                if (canUpdate(i, j)) {
                                    update(i, j, false, true);
                                }
                            }

                            if (arr[i] < arr[j]) { // 바뀐 적이 없는 증가 수열에 추가했을 때 감소하는 경우
                                if (canUpdate(i, j)) {
                                    update(i, j, true, false);
                                }
                            }
                        }

                        if (!lastState.isUp) { // 바뀐 적이 없는 감소 수열인 경우
                            if (arr[j] > arr[i]) { // 바뀐 적이 없는 감소 수열에 추가했을 때 그대로 감소 수열인 경우
                                if (canUpdate(i, j)) {
                                    update(i, j, false, false);
                                }
                            }

                            if (arr[j] < arr[i]) { // 바뀐 적이 없는 감소 수열에 추가했을 때, 증가하는 경우
                                if (canUpdate(i, j)) {
                                    update(i, j, true, true);
                                }
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