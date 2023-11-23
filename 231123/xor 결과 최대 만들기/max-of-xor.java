import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m, answer = Integer.MIN_VALUE;
    private static int[] numbers;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        recursive(new ArrayList<>(), 0);

        System.out.println(answer);
    }

    private static void recursive(List<Integer> nums, int idx) {
        if (nums.size() == m) {
            int result = xor(nums);
            answer = Math.max(answer, result);
        }

        for (int i = idx; i < n; i++) {
            nums.add(numbers[i]);
            recursive(nums, idx + 1);
            nums.remove(nums.size() - 1);
        }
    }

    private static int xor(List<Integer> nums) {
        List<String> binaries = toBinaries(nums);
        int maxLength = maxLength(binaries);
        List<String> formatted = format(binaries, maxLength);

        List<Integer> resultBinary = applyXor(formatted, maxLength);
        return toDecimal(resultBinary);
    }

    private static int toDecimal(List<Integer> resultBinary) {
        int result = 0;

        int power = 0;
        for (int i = resultBinary.size() - 1; i >= 0; i--) {
            result += (int) Math.pow(2, power) * resultBinary.get(i);
            power++;
        }
        return result;
    }

    private static List<String> toBinaries(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    private static int maxLength(List<String> binaries) {
        return binaries.stream()
                .mapToInt(String::length)
                .max().getAsInt();
    }

    private static List<String> format(List<String> binaries, int maxLength) {
        List<String> result = new ArrayList<>();
        for (String binary : binaries) {
            if (binary.length() < maxLength) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < maxLength - binary.length(); i++) {
                    sb.append("0");
                }
                sb.append(binary);
                result.add(sb.toString());
                continue;
            }

            result.add(binary);
        }
        return result;
    }

    private static List<Integer> applyXor(List<String> formatted, int maxLength) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            boolean insert = false;

            for (String binary : formatted) {
                if (binary.charAt(i) - '0' == 1) {
                    insert = true;
                    result.add(1);
                    break;
                }
            }

            if (!insert) {
                result.add(0);
            }
        }

        return result;
    }
}