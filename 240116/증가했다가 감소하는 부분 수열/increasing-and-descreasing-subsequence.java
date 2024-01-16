import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int UP = 0;
    private static final int DOWN = 1;

    private static int n;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][UP] = 1;
            dp[i][DOWN] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // 추가했을 때 증가하면
                    dp[i][UP] = Math.max(dp[i][DOWN], dp[j][UP] + 1); // 증가하는 케이스에 대한 dp 값 갱신
                }

                if (arr[j] > arr[i]) { // 추가했을 때 감소하면
                    dp[i][DOWN] = Math.max(dp[i][DOWN], dp[j][DOWN] + 1);
                }
            }

            // 증가-감소로 변하는 경우
            dp[i][DOWN] = Math.max(dp[i][DOWN], dp[i][UP]); // `dp[i][UP] + 1`이 아닌 이유?
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}