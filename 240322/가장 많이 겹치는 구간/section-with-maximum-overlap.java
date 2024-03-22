import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_NUMBER = 200000;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] checked = new int[MAX_NUMBER + 1];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            checked[s]++;
            checked[e]--;
        }

        int[] sum = new int[MAX_NUMBER + 1];
        for (int i = 1; i <= MAX_NUMBER; i++) {
            sum[i] = sum[i - 1] + checked[i];
        }

        int answer = -1;
        for (int i = 1; i <= MAX_NUMBER; i++) {
            answer = Math.max(answer, sum[i]);
        }
        System.out.println(answer);
    }
}