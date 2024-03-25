import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, String> strings = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String string = sc.nextLine();
            strings.put(i, string);
        }

        for (int i = 0; i < n; i++) {
            String string = strings.get(i);
            String[] split = string.split("");
            Arrays.sort(split);
            
            StringBuilder sb = new StringBuilder();
            for (String word : split) {
                sb.append(word);
            }
            strings.put(i, sb.toString());
        }

        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String string = strings.get(i);
            map.put(string, map.getOrDefault(string, 0) + 1);
            int cnt = map.get(string);
            answer = Math.max(answer, cnt);
        }
        System.out.print(answer);
    }
}