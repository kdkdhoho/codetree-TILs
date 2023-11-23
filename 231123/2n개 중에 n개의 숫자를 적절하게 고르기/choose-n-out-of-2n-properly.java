import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, answer = Integer.MAX_VALUE;
    private static int[] numbers;
    private static int totalSum = 0;

    public static void main(String[] args) {
        n = sc.nextInt();
        numbers = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            numbers[i] = sc.nextInt();
            totalSum += numbers[i];
        }

        recursive(0, 0, 0);

        System.out.println(answer);
    }

    private static void recursive(int idx, int cnt, int sum) {
        if (cnt == n) {
            int diff = Math.abs((totalSum - sum) - sum);
            answer = Math.min(answer, diff);
            return;
        }

        if (idx == numbers.length) {
            return;
        }

        // 선택 X
        recursive(idx + 1, cnt, sum);

        // 선택
        sum += numbers[idx];
        recursive(idx + 1, cnt + 1, sum);
    }
}