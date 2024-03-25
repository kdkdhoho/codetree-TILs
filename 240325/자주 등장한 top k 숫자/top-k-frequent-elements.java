import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Number> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            int cnt = map.get(num);
            pq.add(new Number(num, cnt));
        }

        while (k-- > 0) {
            Number number = pq.poll();
            answer.append(number.value).append(" ");
        }
        System.out.print(answer);
    }
}

class Number implements Comparable<Number> {
    int value;
    int cnt;

    public Number(int value, int cnt) {
        this.value = value;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Number o) {
        if (this.cnt == o.cnt) {
            return -(this.value - o.value);
        }
        return -(this.cnt - o.cnt);
    }
}