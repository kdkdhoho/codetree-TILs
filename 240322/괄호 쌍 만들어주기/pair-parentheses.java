import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static String s;
    private static final List<Integer> openers = new ArrayList<>();
    private static final List<Integer> closers = new ArrayList<>();

    public static void main(String[] args) {
        s = sc.nextLine();
        int n = s.length();

        int[] R = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1];

            if (s.charAt(i) == ')' && (s.charAt(i) == s.charAt(i + 1))) {
                R[i]++;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            char c = s.charAt(i);

            if (c == '(' && (s.charAt(i + 1) == c)) {
                cnt += R[i + 2];
            }
        }
        System.out.print(cnt);
    }
}