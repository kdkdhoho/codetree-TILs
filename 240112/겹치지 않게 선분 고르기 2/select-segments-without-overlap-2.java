import static java.lang.Math.max;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static Line[] lines;
    private static int[] dp; // dp[i]: start 기준으로 정렬되어 있다는 가정 하에, i번째 선분을 끝으로 겹치지 않게 선택할 수 있는 최대 선분의 수

    public static void main(String[] args) {
        read();

        // 모든 선분을 start를 기준으로 정렬한다.
        Arrays.sort(lines);

        // 각 선분을 하나씩만 골랐을 때의 경우를 고려해 모두 1로 초기화한다.
        Arrays.fill(dp, 1);

        // 모든 각각의 선분에 대해서 선택을 고려한다. 이때 각 선분은 i번 째 선분이다.
        // 첫 번째부터 i-1번 째 선분을 마지막으로 뽑은 경우에 i번 째 선분을 고를 수 있는지 본다.
        // 겹치지 않는다면, 겹치지 않으면서 고를 수 있는 최대의 선분 수를 dp 테이블에 기록한다.
        for (int i = 0; i < n; i++) {
            int currentStart = lines[i].start();

            for (int j = 0; j < i; j++) {
                int lastEnd = lines[j].end();

                // 마지막으로 고른 선분의 end 위치보다, 현재 고르려는 선분의 start 위치가 더 크면 무조건 겹치지 않음
                if (lastEnd < currentStart) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = max(answer, dp[i]);
        }
        System.out.println(answer);
    }

    private static void read() {
        n = sc.nextInt();
        lines = new Line[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lines[i] = new Line(start, end);
        }
        dp = new int[n];
    }
}

class Line implements Comparable<Line> {

    private final int start;
    private final int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Line o) {
        return this.start - o.start;
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }
}