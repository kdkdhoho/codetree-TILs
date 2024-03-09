import java.util.Arrays;
import java.util.Scanner;

/**
 * n개의 수가 있다. 두 번째로 작은 수의 위치를 출력하시오.
 * <p>
 * 이때, 두 번째로 작은 수가 없거나 여러 개가 있는 경우 -1을 출력하시오
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Number[] numbers = new Number[n];
        for (int i = 0; i < n; i++) {
            int position = i + 1;
            int value = sc.nextInt();

            numbers[i] = new Number(position, value);
        }

        Arrays.sort(numbers);

        Number minNumber = numbers[0];
        Number minNumber2 = null;
        for (int i = 1; i < n; i++) {
            int value = numbers[i].value;

            if (minNumber2 != null && value == minNumber2.value) {
                System.out.println(-1);
                return;
            }

            if (value < minNumber.value) {
                minNumber2 = minNumber;
                minNumber = numbers[i];
                continue;
            }

            if (minNumber2 == null && value > minNumber.value) {
                minNumber2 = numbers[i];
                continue;
            }

            if (minNumber2 != null && value > minNumber.value && value < minNumber2.value) {
                minNumber2 = numbers[i];
            }
        }

        if (minNumber2 == null) {
            System.out.println(-1);
            return;
        }
        System.out.println(minNumber2.position);
    }
}

class Number implements Comparable<Number> {

    int position;
    int value;

    public Number(int position, int value) {
        this.position = position;
        this.value = value;
    }

    @Override
    public int compareTo(Number o) {
        return this.value - o.value;
    }
}