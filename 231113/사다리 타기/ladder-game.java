import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m, answer = Integer.MAX_VALUE;
    private static int maxHeight;
    private static int[] init;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        Step[] steps = new Step[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 왼쪽 가로줄 번호
            int b = sc.nextInt(); // 높이

            Step step = new Step(a, b);
            steps[i] = step;
        }
        maxHeight = Arrays.stream(steps)
                .mapToInt(Step::height)
                .max().getAsInt();

        init = play(steps);

        int[] emptyResult = play(new Step[0]);
        if (isSame(init, emptyResult)) {
            answer = 0;
        }

        for (int size = 1; size <= n; size++) {
            recursive(size, new ArrayList<>(), steps);
        }
        System.out.println(answer);
    }

    private static void recursive(int size, List<Step> current, Step[] origin) {
        if (current.size() == size) {
            int[] result = play(current);
            if (isSame(init, result)) {
                answer = Math.min(answer, current.size());
            }
            return;
        }

        for (int index = 0; index < origin.length; index++) {
            current.add(origin[index]);
            recursive(size, current, origin);
            current.remove(current.size() - 1);
        }
    }

    private static boolean isSame(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new RuntimeException();
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] play(List<Step> steps) {
        return play(steps.toArray(new Step[steps.size()]));
    }

    private static int[] play(Step[] steps) {
        int[] result = new int[n];
        for (int num = 1; num <= n; num++) {
            int position = num;
            int height = 1;
            while (height <= maxHeight) {
                List<Step> sameHeightSteps = findStepByHeight(height, steps);
                if (sameHeightSteps.isEmpty()) {
                    height++;
                    continue;
                }

                Step movableStep = findStepByPosition(position, sameHeightSteps.toArray(new Step[sameHeightSteps.size()]));

                // 이동할 수 있는 Step이 없으면 높이 +1 하고 다음으로
                if (movableStep == null) {
                    height++;
                    continue;
                }

                // 이동할 수 있으면
                position = movableStep.move(position); // Step 타고 이동
                height++;
            }

            result[num - 1] = position;
        }
        return result;
    }

    // 같은 높이의 Steps 모두 조회
    private static List<Step> findStepByHeight(int height, Step[] steps) {
        return Arrays.stream(steps)
                .filter(step -> step.height == height)
                .collect(Collectors.toList());
    }

    // 주어진 위치에서 이동할 수 있는 하나의 Step 반환
    private static Step findStepByPosition(int position, Step[] steps) {
        for (Step step : steps) {
            if (step.leftLadderNum == position || step.leftLadderNum == position - 1) {
                return step;
            }
        }
        return null;
    }
}

class Step {
    int leftLadderNum;
    int height;

    public Step(int leftLadderNum, int height) {
        this.leftLadderNum = leftLadderNum;
        this.height = height;
    }

    public int height() {
        return height;
    }

    public int move(int position) {
        if (!(leftLadderNum == position || leftLadderNum == position - 1)) {
            throw new RuntimeException();
        }

        if (leftLadderNum == position) {
            return position + 1;
        }
        return position - 1;
    }
}