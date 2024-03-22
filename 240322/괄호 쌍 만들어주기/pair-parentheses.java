import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static String s;

    public static void main(String[] args) {
        s = sc.nextLine();

        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '(' && c == s.charAt(i + 1)) {
                arr[i] = 1;
                continue;
            }

            if (c == ')' && c == s.charAt(i + 1)) {
                arr[i] = -1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                for (int j = arr.length - 1; j > i; j--) {
                    if (arr[j] == -1) {
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}