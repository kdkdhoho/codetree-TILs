import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int answer = -1;
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        for (int end = k; end <= n; end++) {
            int tmp = end - k;

            int result = sum[end] - sum[tmp];
            answer = Math.max(answer, result);
        }
        System.out.print(answer);
    }
}