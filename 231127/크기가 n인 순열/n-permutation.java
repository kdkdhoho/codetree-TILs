import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        n = sc.nextInt();

        recursive(new ArrayList<>(), new boolean[n + 1]);
        System.out.print(answer);
    }

    private static void recursive(List<Integer> pickedNumbers, boolean[] used) {
        if (pickedNumbers.size() == n) {
            String result = pickedNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            answer.append(result).append(System.lineSeparator());
            return;
        }

        for (int number = 1; number <= n; number++) {
            if (!used[number]) {
                pickedNumbers.add(number);
                used[number] = true;

                recursive(pickedNumbers, used);

                used[number] = false;
                pickedNumbers.remove(pickedNumbers.size() - 1);
            }
        }
    }
}