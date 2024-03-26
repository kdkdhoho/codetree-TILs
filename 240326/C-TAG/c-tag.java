import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String[] groupA = new String[n];
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.nextLine();
        }
        String[] groupB = new String[n];
        for (int i =0 ; i < n; i++) {
            groupB[i] = sc.nextLine();
        }

        int answer = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    StringBuilder sb = new StringBuilder();
                    for (int a = 0; a < n; a++) {
                        String str = groupA[a];
                        sb.append(str.charAt(i)).append(str.charAt(j)).append(str.charAt(k));
                        String combine = sb.toString();
                        sb.setLength(0);
                        set.add(combine);
                    }

                    boolean flag = true;
                    for (int b = 0; b < n; b++) {
                        String str = groupB[b];
                        sb.append(str.charAt(i)).append(str.charAt(j)).append(str.charAt(k));
                        String combine = sb.toString();
                        sb.setLength(0);

                        if (set.contains(combine)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        answer++;
                    }

                    set.clear();
                }
            }
        }

        System.out.print(answer);
    }
}