import static java.lang.Math.max;
import static java.util.Comparator.comparingInt;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue<Pair> total = new PriorityQueue<>(comparingInt(p -> p.a));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(i, sc.nextInt(), sc.nextInt());
            total.add(pair);
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        int currentTime = 0;

        while (!total.isEmpty()) {
            Pair pair = total.poll();

            if (pair.a <= currentTime) {
                int waitingTime = currentTime - pair.a;
                answer = max(answer, waitingTime);
                currentTime += pair.t;
            } else {
                currentTime = pair.a + pair.t;
            }

            PriorityQueue<Pair> waiters = new PriorityQueue<>(comparingInt(p -> p.idx));
            while (!total.isEmpty() && total.peek().a <= currentTime) {
                waiters.add(total.poll());
            }

            while (!waiters.isEmpty()) {
                Pair waiter = waiters.poll();
                int waitingTime = currentTime - waiter.a;
                answer = max(answer, waitingTime);
                currentTime += waiter.t;
            }
        }
        System.out.println(answer);
    }
}

class Pair {
    int idx;
    int a;
    int t;

    public Pair(int idx, int a, int t) {
        this.idx = idx;
        this.a = a;
        this.t = t;
    }
}