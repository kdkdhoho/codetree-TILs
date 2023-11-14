import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * n*n격자에 각 칸마다 1 ~ n*n 이하의 숫자와 여덟 방향 중 한 방향이 주어진다.
 * 숫자는 중복없이 하나씩만 주어진다.
 * <p>
 * 이때, 특정 위치에서 시작해서 적혀있는 방향에 있는 숫자들 중에, 현재 숫자보다 더 큰 숫자가 적힌 곳으로 이동하는 것을 최대한 많이 하려고 한다.
 * <p>
 * 1. 시작 위치에서 방향을 쭉 타면서, 시작위치 값보다 큰 block들을 List로 뽑는다.
 * 2. 뽑힌 List를 순회하면서 이동해본다.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n; // 격자 크기
    private static Block[][] arr;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new Block[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = sc.nextInt();
                arr[i][j] = new Block(number);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                Block block = arr[i][j];
                block.setDirection(Direction.of(value));
            }
        }

        int row = sc.nextInt() - 1;
        int col = sc.nextInt() - 1;
        List<Block> blocks = pickBlocks(row, col);
        if (blocks.isEmpty()) {
            System.out.print(0);
        } else {
            recursive(blocks, 0);
            System.out.println(answer);
        }
    }

    private static void recursive(List<Block> blocks, int cnt) {
        if (blocks.isEmpty()) {
            answer = Math.max(answer, cnt);
            return;
        }

        for (Block block : blocks) {
            int row = findRow(block);
            int col = findCol(block);
            List<Block> newBlocks = pickBlocks(row, col);
            recursive(newBlocks, cnt + 1);
        }
    }

    private static int findRow(Block block) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (arr[row][col].number == block.number) {
                    return row;
                }
            }
        }
        throw new RuntimeException();
    }

    private static int findCol(Block block) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (arr[row][col].number == block.number) {
                    return col;
                }
            }
        }
        throw new RuntimeException();
    }

    private static List<Block> pickBlocks(int row, int col) {
        List<Block> result = new ArrayList<>();
        Block block = arr[row][col];

        while (true) {
            int nextRow = block.nextRow(row);
            int nextCol = block.nextCol(col);

            if (isOut(nextRow, nextCol)) {
                break;
            }

            Block nextBlock = arr[nextRow][nextCol];
            if (nextBlock.number > block.number) {
                result.add(nextBlock);
            }

            row = nextRow;
            col = nextCol;
        }

        return result;
    }

    private static boolean isOut(int row, int col) {
        return row < 0 || col < 0 || row >= n || col >= n;
    }
}

class Block {
    int number;
    Direction direction;

    public Block(int number) {
        this.number = number;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int nextRow(int row) {
        return direction.nextRow(row);
    }

    public int nextCol(int col) {
        return direction.nextCol(col);
    }
}

enum Direction {
    UP(1),
    UP_RIGHT(2),
    RIGHT(3),
    RIGHT_DOWN(4),
    DOWN(5),
    DOWN_LEFT(6),
    LEFT(7),
    LEFT_UP(8);

    private static int[] dRow = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dCol = {0, 1, 1, 1, 0, -1, -1, -1};

    private int value;

    Direction(int value) {
        this.value = value;
    }

    public static Direction of(int value) {
        for (Direction direction : Direction.values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        throw new RuntimeException();
    }

    public int nextRow(int row) {
        return row + dRow[value - 1];
    }

    public int nextCol(int col) {
        return col + dCol[value - 1];
    }
}