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
    private static double minDistance = Double.MAX_VALUE;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        recursive(0, 0, new ArrayList<>(), points);

        System.out.println((int) Math.pow(minDistance, 2));
    }

    /**
     * m개의 점을 골랐을 때, 가장 거리가 먼 두 점을 가진다.
     * 이 두 점의 거리의 최대를 answer에 갱신한다.
     * <p>
     * pickedCount은 0부터 시작한다.
     */
    private static void recursive(int pickedCount, int pickIndex, List<Point> pickedPoints, Point[] points) {
        if (pickedCount == m) {
            double distance = pickedPoints.get(0).distance(pickedPoints.get(1));
            minDistance = Math.min(minDistance, distance);
            return;
        }

        if (pickIndex == points.length) {
            return;
        }

        // 선택하지 않았을 때
        recursive(pickedCount, pickIndex + 1, pickedPoints, points);

        // 선택했을 때
        Point point = points[pickIndex];
        if (pickedPoints.size() < 2) { // 아직 2개를 못 구했을 때
            pickedPoints.add(point); // 넣고 재귀돌림
            recursive(pickedCount + 1, pickIndex + 1, pickedPoints, points);
        } else {
            // 2개 구했을 때 거리가 가장 먼 두 점을 구한다
            double distance1 = point.distance(pickedPoints.get(0));
            double distance2 = point.distance(pickedPoints.get(1));

            if (distance1 > distance2) { // point와 point[0]의 거리가 더 멀면
                // 리스트 갱신하고, 다음 재귀 진행
                pickedPoints.remove(1);
                pickedPoints.add(point);
                recursive(pickedCount + 1, pickIndex + 1, pickedPoints, points);
            } else if (distance2 > distance1) { // point와 point[1]의 거리가 더 멀면
                // 리스트 수정하고 다음 재귀 진행
                pickedPoints.remove(0);
                pickedPoints.add(point);
                recursive(pickedCount + 1, pickIndex + 1, pickedPoints, points);
            } else { // point[0]과 point[1]의 거리가 더 멀면
                // 현재 상태 그대로 다음 재귀 진행
                recursive(pickedCount + 1, pickIndex + 1, pickedPoints, points);
            }
        }
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