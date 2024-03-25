import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");

            String command = split[0];
            if (command.equals("add")) {
                int k = Integer.parseInt(split[1]);
                int v = Integer.parseInt(split[2]);
                map.put(k, v);
                continue;
            }

            if (command.equals("find")) {
                int k = Integer.parseInt(split[1]);
                if (map.containsKey(k)) {
                    System.out.println(map.get(k));
                    continue;
                }
                System.out.println("None");
                continue;
            }

            if (command.equals("remove")) {
                int k = Integer.parseInt(split[1]);
                map.remove(k);
            }
        }
    }
}