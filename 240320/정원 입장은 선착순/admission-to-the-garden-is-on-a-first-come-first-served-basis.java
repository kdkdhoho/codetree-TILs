import static java.lang.Math.max;
import static java.util.Comparator.comparingInt;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1부터 n까지 번호표를 든 사람들이 있다.
 * i번 사람은 Ai 시간에 입구에 도착해서 Ti 시간 동안 정원에 머무른다.
 * 정원에는 한 번에 한 명만 들어갈 수 있으며, i번 사람이 입구에 도착했을 때 이미 누군가 정원에 있다면
 * 내부에 있는 사람이 떠날 때까지 대기했다가 출입할 수 있다.
 * <p>
 * 기다리는 사람이 여러명이라면, 번호표 숫자가 작은 순대로 줄을 선다.
 * 모든 사람이 정원을 한 번씩 들려갈 때, 이들 중 가장 오래 기다려야 하는 사람이 기다리는 시간을 구하시오.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue<Pair> total = new PriorityQueue<>(comparingInt(p -> p.a));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(i, sc.nextInt(), sc.nextInt());
            total.add(pair);
        }

        int answer = 0;
        int currentTime = 0;

        while (!total.isEmpty()) {
            Pair pair = total.poll();
            currentTime = pair.a + pair.t;
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