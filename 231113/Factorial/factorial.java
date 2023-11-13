import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int result = factorial(n);
        System.out.println(result);
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}