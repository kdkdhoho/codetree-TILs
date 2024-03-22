/**
폭탄 N개가 있다.
폭탄에는 각자 번호가 있고 같은 번호가 부여된 폭탄끼리 거리가 K안에 있다면 폭발한다.

N, K, 그리고 폭탄을 나열할 순서가 주어졌을 때, 폭발 할 폭탄 중에 부여된 번호가 가장 큰 번호를 출력하시오.
*/
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, k;
    private static int[] numbers;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        
        numbers = new int[n];
        for (int i =0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        HashSet<Integer>[] R = new HashSet[n];
        for (int i = 0; i < n; i++) {
            R[i] = new HashSet<>();
        }
        for (int i = n - 1; i >= 0; i--) {
            HashSet<Integer> set = R[i];
            set.add(numbers[i]);
        }

        int answer = -1;
        for (int i = 0; i <= n - 1 - k; i++) {
            if (R[i + k].contains(numbers[i])) {
                answer = Math.max(answer, numbers[i]);
            }
        }
        System.out.print(answer);
    }
}