import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, m, answer = Integer.MAX_VALUE;
    private static int maxHeight;

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

        if (isSame(play(steps), play(new Step[0]))) {
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
            if (isSame(play(origin), result)) {
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
                Step movableStep = findMovableStep(position, height, steps);
                if (movableStep == null) {
                    height++;
                    continue;
                }

                position = movableStep.move(position);
                height++;
            }

            result[num - 1] = position;
        }
        return result;
    }

    private static Step findMovableStep(int position, int height, Step[] steps) {
        for (Step step : steps) {
            if (step.movable(position, height)) {
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

    public boolean movable(int position, int height) {
        if (this.height != height) {
            return false;
        }

        if (position == leftLadderNum || position == leftLadderNum + 1) {
            return true;
        }
        return false;
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

    public int height() {
        return height;
    }
}