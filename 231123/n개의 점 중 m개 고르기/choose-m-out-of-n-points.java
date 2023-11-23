import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m;
    private static Point[] points;
    private static double answer = Double.MAX_VALUE;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        recursive(new ArrayList<>(), 0, 0);

        System.out.println((int) Math.pow(answer, 2));
    }

    private static void recursive(List<Point> choose, int idx, double dist) {
        if (choose.size() == m) {
            answer = Math.min(dist, answer);
            return;
        }

        if (idx == n) {
            return;
        }

        // 선택 X
        recursive(choose, idx + 1, dist);

        // 선택 O
        Point p = points[idx];
        double maxDist = 0;
        for (Point point : choose) {
            maxDist = Math.max(maxDist, p.dist(point));
        }
        choose.add(p);
        recursive(choose, idx + 1, maxDist);
    }
}

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double dist(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}