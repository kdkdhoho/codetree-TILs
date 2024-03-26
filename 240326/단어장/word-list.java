import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder answer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = String.format("%s %d", entry.getKey(), entry.getValue());
            answer.append(s).append("\n");
        }
        System.out.print(answer);
    }
}