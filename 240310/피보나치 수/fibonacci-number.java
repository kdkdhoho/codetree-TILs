import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n - 1]);
    }
}