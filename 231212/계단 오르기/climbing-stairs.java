import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] memo = new int[n + 1];

        if (n == 2) {
            System.out.println(1);
            return;
        }

        memo[2] = 1;
        memo[3] = 1;

        for (int i = 4; i < memo.length; i++) {
            memo[i] = (memo[i - 2] + memo[i - 3]) % 10_007;
        }

        int answer = 0;
        if (memo[n] != 0) {
            answer = memo[n];
        }
        System.out.println(answer);
    }
}