import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int answer = -1;
        Map<String, Integer> map = new HashMap<>();

        for (int i =0; i < n; i++) {
            String s = sc.nextLine();
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
            
            answer = Math.max(answer, count);
        }

        System.out.print(answer);
    }
}