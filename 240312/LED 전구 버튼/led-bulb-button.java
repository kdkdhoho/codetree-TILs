import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static long b;
    private static int[] lights;

    public static void main(String[] args) {
        n = sc.nextInt();
        b = (sc.nextLong() % (int) (Math.pow(2, n - 1))) + 1;

        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(0);
            }
            return;
        }

        lights = new int[n];
        for (int i = 0; i < n; i++) {
            lights[i] = sc.nextInt();
        }

        boolean allZero = true;
        for (int i = 0; i < n; i++) {
            if (lights[i] == 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            for (int i = 0; i < n; i++) {
                System.out.println(0);
            }
            return;
        }

        for (int cnt = 0; cnt < b; cnt++) {
            int[] newLights = new int[n];

            for (int i = 0; i < n; i++) {
                int leftIndex = i - 1;
                if (leftIndex < 0) {
                    leftIndex = n - 1;
                }

                if (lights[leftIndex] == 1) {
                    if (lights[i] == 1) {
                        newLights[i] = 0;
                    } else {
                        newLights[i] = 1;
                    }
                } else {
                    newLights[i] = lights[i];
                }
            }

            for (int i = 0; i < n; i++) {
                lights[i] = newLights[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(lights[i]).append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}