import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_NUMBER = 200000;

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            points.add(new Point(start, 1));
            points.add(new Point(end, -1));
        }

        Collections.sort(points);

        int answer = -1;
        int cnt = 0;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            cnt += point.value;
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}

class Point implements Comparable<Point> {
    int x, value;

    public Point(int x, int value) {
        this.x = x;
        this.value = value;
    }

    @Override
    public int compareTo(Point o) {
        return this.x - o.x;
    }
}