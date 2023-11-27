import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m;
    private static Point[] points;
    private static BigDecimal answer = new BigDecimal(Double.MAX_VALUE);

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        recursive(new ArrayList<>(), 0);

        double result = Math.round(answer.pow(2).doubleValue() * 10.0) / 10.0;
        System.out.println((int) result);
    }

    private static void recursive(List<Point> pickedPoints, int pickIndex) {
        if (pickedPoints.size() == m) {
            double maximumTwoPointsDistance = Double.MIN_VALUE;
            for (int i = 0; i < pickedPoints.size() - 1; i++) {
                for (int j = i + 1; j < pickedPoints.size(); j++) {
                    double distance = pickedPoints.get(i).distance(pickedPoints.get(j));
                    maximumTwoPointsDistance = Math.max(maximumTwoPointsDistance, distance);
                }
            }

            if (maximumTwoPointsDistance < answer.doubleValue()) {
                answer = new BigDecimal(maximumTwoPointsDistance);
            }
            return;
        }

        if (pickIndex == points.length) {
            return;
        }

        pickedPoints.add(points[pickIndex]);
        recursive(pickedPoints, pickIndex + 1);
        pickedPoints.remove(pickedPoints.size() - 1);

        recursive(pickedPoints, pickIndex + 1);
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
}