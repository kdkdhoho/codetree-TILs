import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static Line[] lines;
    private static final List<Line> pickedLines = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        lines = new Line[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lines[i] = new Line(start, end);
        }

        Arrays.sort(lines, Comparator.comparing(Line::length));

        for (int i = 0; i < n; i++) {
            Line line = lines[i];
            boolean canPick = true;

            for (Line pickedLine : pickedLines) {
                if (pickedLine.isOverlap(line)) {
                    canPick = false;
                    break;
                }
            }

            if (canPick) {
                pickedLines.add(line);
            }
        }

        System.out.println(pickedLines.size());
    }
}

class Line {

    private final int start;
    private final int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int length() {
        return end - start;
    }

    public boolean isOverlap(Line other) {
        if ((other.start < this.start && other.end < this.start)
                || (other.start > this.end && other.end > this.end)
        ) {
            return false;
        }
        return true;
    }
}