import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, answer = 0;

    public static void main(String[] args) {
        n = sc.nextInt();

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(n, 0));

        while (!queue.isEmpty()) {
            Number number = queue.poll();

            if (number.value() == 1) {
                answer = number.operationCount();
                return;
            }

            if (number.canDivide(2) || number.canDivide(3)) {
                if (number.canDivide(2)) {
                    queue.add(number.divide(2));
                }
                if (number.canDivide(3)) {
                    queue.add(number.divide(3));
                }
                continue;
            }

            queue.add(number.minus());
            queue.add(number.plus());
        }
    }
}

class Number {
    private final int value;
    private final int operationCount;

    public Number(int value, int operationCount) {
        this.value = value;
        this.operationCount = operationCount;
    }

    public boolean canDivide(int denominator) {
        return value % denominator == 0;
    }

    public Number divide(int denominator) {
        int result = value / denominator;

        return new Number(result, operationCount + 1);
    }

    public Number minus() {
        return new Number(value - 1, operationCount + 1);
    }

    public Number plus() {
        return new Number(value + 1, operationCount + 1);
    }

    public int value() {
        return value;
    }

    public int operationCount() {
        return operationCount;
    }
}