import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (i == 2 || i == 3) {
                dp[i] = 1;
                continue;
            }
            dp[i] = (dp[i - 3] + dp[i - 2]) % 10_007;
        }
        System.out.println(dp[n]);
    }
}