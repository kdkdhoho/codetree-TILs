import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number > 0) {
                numbers.add(number);
                numbers.sort(Collections.reverseOrder());
            } else {
                if (numbers.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(numbers.get(0));
                    numbers.remove(0);
                }
            }
        }
    }
}