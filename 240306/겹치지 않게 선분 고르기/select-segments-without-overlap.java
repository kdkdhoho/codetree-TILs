import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, answer = Integer.MIN_VALUE;
    private static Line[] lines;

    public static void main(String[] args) {
        n = sc.nextInt();
        lines = new Line[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }

        recursive(0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void recursive(int index, List<Line> choiceLines) {
        if (index >= lines.length) {
            List<Line> removed = removeOverlapLines(new ArrayList<>(choiceLines));
            answer = Math.max(answer, removed.size());
            return;
        }

        Line line = lines[index];

        choiceLines.add(line);
        recursive(index + 1, choiceLines);
        choiceLines.remove(choiceLines.size() - 1);

        recursive(index + 1, choiceLines);
    }

    private static List<Line> removeOverlapLines(List<Line> choiceLines) {
        for (int i = choiceLines.size() - 1; i >= 0; i--) {
            Line target = choiceLines.get(i);

            for (int j = 0; j < choiceLines.size(); j++) {
                if (i == j) {
                    continue;
                }

                Line other = choiceLines.get(j);

                if (target.isOverlap(other)) {
                    choiceLines.remove(i);
                    break;
                }
            }
        }

        return choiceLines;
    }
}

class Line {

    int start;
    int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isOverlap(Line other) {
        return other.start <= this.end && other.end >= this.start;
    }
}