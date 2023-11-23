import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static String[][] arr;
    private static final Map<String, Point> points = new HashMap<>();
    private static final List<Integer> numbers = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        n = Integer.parseInt(sc.nextLine());
        arr = new String[n][n];
        for (int row = 0; row < n; row++) {
            String[] inputs = sc.nextLine().split("");
            for (int col = 0; col < n; col++) {
                arr[row][col] = inputs[col];
                if (!arr[row][col].equals(".")) {
                    points.put(arr[row][col], new Point(row, col));
                }

                try {
                    int number = Integer.parseInt(arr[row][col]);
                    numbers.add(number);
                } catch (Exception e) {
                    // ignore
                }
            }
        }

        if (numbers.size() < 3) {
            System.out.print(-1);
        } else {
            recursive(0, points.get("S"), 0, 0);

            if (answer == Integer.MAX_VALUE) {
                System.out.print(-1);
            } else {
                System.out.print(answer);
            }
        }
    }

    private static void recursive(int idx, Point start, int totalDist, int cnt) {
        if (cnt == 3) {
            totalDist += dist(start, points.get("E"));
            answer = Math.min(answer, totalDist);
            return;
        }

        if (idx == numbers.size()) {
            return;
        }

        // 선택하지 않았을 때
        recursive(idx + 1, start, totalDist, cnt);

        // 선택했을 때
        int targetNumber = numbers.get(idx);
        Point target = points.get(String.valueOf(targetNumber));
        totalDist += dist(start, target);
        recursive(idx + 1, target, totalDist, cnt + 1);
    }

    private static int dist(Point start, Point target) {
        return start.distance(target);
    }
}

class Point {

    private final int row;
    private final int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int distance(Point target) {
        return Math.abs(row - target.row) + Math.abs(col - target.col);
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }
}