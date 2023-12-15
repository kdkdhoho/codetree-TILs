import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final BigDecimal MOD = new BigDecimal(1_000_000_007);
    private static final int MAX_N = 1000;

    public static void main(String[] args) {
        int n = sc.nextInt();
        BigDecimal[] dp = new BigDecimal[MAX_N + 1];

        dp[0] = new BigDecimal(1L);
        dp[1] = new BigDecimal(2L);
        dp[2] = new BigDecimal(7L);

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1].multiply(new BigDecimal(3)).add(dp[i - 2]).subtract(dp[i - 3]);
        }
        System.out.println(dp[n].remainder(MOD));
    }
}