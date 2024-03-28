import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        TreeSet<Integer> treeSet = new TreeSet();

        for (int i = 0; i < n; i++) {
            treeSet.add(sc.nextInt());
        }

        Set<Integer> sortedSet = treeSet.descendingSet();
        List<Integer> list =  new ArrayList<>(sortedSet);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            answer.append(list.get(i)).append(" ");
        }
        System.out.print(answer);
    }
}