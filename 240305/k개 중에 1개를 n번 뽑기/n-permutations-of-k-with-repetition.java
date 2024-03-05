import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, k;

    public static void main(String[] args) {
        k = sc.nextInt();
        n = sc.nextInt();

        recursive(0, new ArrayList<>());
    }

    private static void recursive(int count, List<String> answer) {
        if (count == n) {
            System.out.println(String.join(" ", answer));
            return;
        }

        for (int num = 1; num <= k; num++) {
            answer.add(String.valueOf(num));
            recursive(count + 1, answer);
            answer.remove(answer.size() - 1);
        }
    }
}