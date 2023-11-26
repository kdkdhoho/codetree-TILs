import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 점 n개가 있다. 이 중 m개를 적절히 선택하고, 선택한 점들 중 거리가 가장 먼 두 점 사이의 거리를 k라고 했을 때,
 * 최소가 되는 k의 제곱을 출력하시오
 */
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

        recursive(new ArrayList<>(), 0, points);
        
        System.out.println((int) Math.pow(answer, 2));
    }

    private static void recursive(List<Point> pickedPoints, int pickIndex, Point[] points) {
        if (pickedPoints.size() == m) {
            double maximumTwoPointsDistance = Double.MIN_VALUE;

            for (int i = 0; i < pickedPoints.size(); i++) {
                for (int j = 0; j < pickedPoints.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    Point point1 = pickedPoints.get(i);
                    Point point2 = pickedPoints.get(j);
                    double distance = point1.distance(point2);

                    maximumTwoPointsDistance = Math.max(maximumTwoPointsDistance, distance);
                }
            }

            answer = Math.min(answer, maximumTwoPointsDistance);
            return;
        }

        if (pickIndex == points.length) {
            return;
        }

        // 선택했을 때
        pickedPoints.add(points[pickIndex]);
        recursive(pickedPoints, pickIndex + 1, points);
        pickedPoints.remove(pickedPoints.size() - 1);
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}