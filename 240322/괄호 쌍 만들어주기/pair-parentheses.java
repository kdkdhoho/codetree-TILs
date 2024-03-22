import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static String s;
    private static final List<Integer> openers = new ArrayList<>();
    private static final List<Integer> closers = new ArrayList<>();

    public static void main(String[] args) {
        s = sc.nextLine();

        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);

            if (c == '(' && c == s.charAt(i + 1)) {
                openers.add(i);
                continue;
            }

            if (c == ')' && c == s.charAt(i + 1)) {
                closers.add(i);
            }
        }

        int cnt = 0;
        for (int opener : openers) {
            for (int closer : closers) {
                if (opener < closer) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}

class Element {
    String type;
    int index;

    public Element(String type, int index) {
        this.type = type;
        this.index = index;
    }
}