import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static int[] dp;

    public static void main(String[] args) {
        n = sc.nextInt();
        dp = new int[n + 1]; // 정수 i를 만들 수 있는 모든 가지 수
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int a = 0;
            int b = 0;
            int c = 0;

            if (inArray(i - 1)) {
                a = dp[i - 1];
            }
            if (inArray(i - 2)) {
                b = dp[i - 2];
            }
            if (inArray(i - 5)) {
                c = dp[i - 5];
            }

            dp[i] = (a + b + c) % 10_007;
        }

        System.out.println(dp[n]);
    }

    private static boolean inArray(int index) {
        return 0 <= index && index < dp.length;
    }
}