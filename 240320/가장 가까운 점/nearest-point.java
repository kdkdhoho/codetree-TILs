import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2차 평면 위에 서로 다른 위치에 n개의 점이 있다.
 * 이때, 원점에서 가장 가까운 점을 하나 골라, 해당 점의 x, y 값에 2를 더하는 작업을 m번 반복한다.
 * m번 반복한 이후에 원점으로부터 가장 가까운 점을 출력하시오.
 * 만약, 거리가 최소인 점이 2개 이상이라면 x값이 가장 작은 작은 점을, 만약 그래도 2개 이상이라면 y가 가장 작은 값을 출력한다.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m;
    private static final PriorityQueue<Point> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            pq.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < m; i++) {
            Point point = pq.poll();
            point.add();
            pq.add(point);
        }

        List<Point> points = new ArrayList<>(pq);
        points.sort((p1, p2) -> {
            if (p1.distanceFromStartingPoint() == p2.distanceFromStartingPoint()) {
                if (p1.x == p2.x) {
                    return p1.y - p2.y;
                }
                return p1.x - p2.x;
            }
            return p1.distanceFromStartingPoint() - p2.distanceFromStartingPoint();
        });

        Point point = points.get(0);
        System.out.printf("%d %d", point.x, point.y);
    }
}

class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceFromStartingPoint() {
        return abs(x) + abs(y);
    }

    public void add() {
        this.x += 2;
        this.y += 2;
    }

    @Override
    public int compareTo(Point o) {
        return this.distanceFromStartingPoint() - o.distanceFromStartingPoint();
    }
}