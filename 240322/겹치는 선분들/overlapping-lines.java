/**
 * 수직선 위에 1부터 N까지의 선분이 있다.
 * 선분 1은 원점에서 시작해서 M(1)만큼 이동하는데 방향은 M(2)에 따라 결정된다.
 * <p>
 * 각 선분의 길이와 방향이 주어질 때, 이 N개의 선분들이 K개 이상 겹치는 곳의 길이 합은?
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, k;
    private static final List<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            int value = Integer.parseInt(split[0]);
            String direction = split[1];

            int start = getStart(i);
            int end = getEnd(start, direction, value);

            savePoints(start, end);
        }

        Collections.sort(points, (p1, p2) -> p1.x - p2.x);

        int cnt = 0;
        int answer = 0;
        int startX = 0;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);

            int x = point.x;
            int value = point.value;

            cnt += value;

            if (value > 0 && cnt == k) {
                startX = x;
            }
            if (value < 0 && cnt == k - 1) {
                int length = Math.abs(startX - x);
                answer += length;
            }
        }

        System.out.print(answer);
    }

    private static int getStart(int i) {
        if (i == 0) {
            return 0;
        }
        return points.get(points.size() - 1).x;
    }

    private static int getEnd(int start, String direction, int value) {
        if ("L".equals(direction)) {
            return start - value;
        }
        return start + value;
    }

    private static void savePoints(int x, int y) {
        if (x < y) {
            points.add(new Point(x, 1));
            points.add(new Point(y, -1));
        } else {
            points.add(new Point(x, -1));
            points.add(new Point(y, 1));
        }
    }
}

class Point {
    int x, value;

    public Point(int x, int value) {
        this.x = x;
        this.value = value;
    }
}