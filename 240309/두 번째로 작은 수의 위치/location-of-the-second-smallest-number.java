import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        int answer = -1;
        int minNumber = Integer.MAX_VALUE;
        int minNumber2 = Integer.MAX_VALUE;

        // 두 번째로 작은 수 찾기
        for (int i=0; i<n; i++) {
            int number = numbers[i];

            if (number < minNumber) {
                minNumber2 = minNumber;
                minNumber = number;
                continue;
            }

            if (number > minNumber && number < minNumber2) {
                minNumber2 = number;
                answer = i + 1;
                continue;
            }
        }

        System.out.print(answer);
    }
}