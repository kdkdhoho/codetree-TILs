import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = -1;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MIN_VALUE) {
                    continue;
                }
                
                if (j + arr[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    answer = Math.max(answer, dp[i]);
                }

                if (dp[i] == 0) {
                    dp[i] = Integer.MIN_VALUE;
                }
            }
        }

        System.out.println(answer);
    }
}