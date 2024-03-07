public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
    }
}import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 사람 수 n과 사다리의 Step이 m개 주어진다.
 * 사다리 Step의 위치는 주어진다.
 * <p>
 * 이때, Step을 최소한으로 골라서 Step이 모두 존재할 때와 동일한 결과를 낳도록 하시오.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m, answer = Integer.MAX_VALUE;
    private static final Steps steps = new Steps(new ArrayList<>());
    private static final List<Integer> expected = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int lineNumber = sc.nextInt();
            int height = sc.nextInt();

            Step step = new Step(lineNumber, height);
            steps.add(step);
        }

        createExpected();

        recursive(0, new ArrayList<>());

        System.out.println(answer);
    }

    private static void createExpected() {
        for (int position = 1; position <= n; position++) {
            int resultPosition = steps.play(position);
            expected.add(resultPosition);
        }
    }

    private static void recursive(int index, List<Step> chooseSteps) {
        if (index >= steps.size()) {
            List<Integer> result = new ArrayList<>();
            Steps steps = new Steps(chooseSteps);
            for (int position = 1; position <= n; position++) {
                int resultPosition = steps.play(position);
                result.add(resultPosition);
            }

            for (int i = 0; i < result.size(); i++) {
                if (expected.get(i) != result.get(i)) {
                    return;
                }
            }

            answer = Math.min(answer, chooseSteps.size());

            return;
        }

        // 골랐을 때
        Step step = steps.get(index);
        chooseSteps.add(step);

        recursive(index + 1, chooseSteps);

        chooseSteps.remove(chooseSteps.size() - 1);

        // 고르지 않았을 때
        recursive(index + 1, chooseSteps);
    }
}

class Steps {

    private final List<Step> steps;

    public Steps(List<Step> steps) {
        this.steps = new ArrayList<>(steps);
    }

    public void add(Step step) {
        steps.add(step);
    }

    public int play(int position) {
        int height = 0;
        int maxHeight = calculateMaxHeight();

        while (height <= maxHeight) {
            height++;
            position = move(height, position);
        }
        return position;
    }

    private int calculateMaxHeight() {
        if (steps.isEmpty()) {
            return 0;
        }
        return steps.stream()
                .mapToInt(Step::getHeight)
                .max().getAsInt();
    }

    private int move(int height, int position) {
        List<Step> sameHeightSteps = filterSameHeight(height);
        for (Step step : sameHeightSteps) {
            if (step.lineNumber == position) {
                return position + 1;
            }
            if (step.lineNumber == position - 1) {
                return position - 1;
            }
        }
        return position;
    }

    private List<Step> filterSameHeight(int height) {
        return steps.stream()
                .filter(step -> step.height == height)
                .collect(Collectors.toList());
    }

    public int size() {
        return steps.size();
    }

    public Step get(int index) {
        return steps.get(index);
    }
}

class Step {

    int lineNumber;
    int height;

    public Step(int lineNumber, int height) {
        this.lineNumber = lineNumber;
        this.height = height;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getHeight() {
        return height;
    }
}