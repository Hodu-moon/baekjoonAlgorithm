
import java.util.*;

public class Main{

    static int[][] map = new int[9][9];
    static List<Position> emptyCells = new ArrayList<>();
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] squareUsed = new boolean[9][10];
    static boolean solved = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 9; j++) {
                int val = line.charAt(j) - '0';
                map[i][j] = val;
                if (val == 0) {
                    emptyCells.add(new Position(i, j));
                } else {
                    rowUsed[i][val] = true;
                    colUsed[j][val] = true;
                    squareUsed[getSquareIndex(i, j)][val] = true;
                }
            }
        }

        backtrack(0);
    }

    static void backtrack(int depth) {
        if (solved) return;

        if (depth == emptyCells.size()) {
            printMap();
            solved = true;
            return;
        }

        Position p = emptyCells.get(depth);
        int x = p.x;
        int y = p.y;
        int square = getSquareIndex(x, y);

        for (int num = 1; num <= 9; num++) {
            if (!rowUsed[x][num] && !colUsed[y][num] && !squareUsed[square][num]) {
                map[x][y] = num;
                rowUsed[x][num] = true;
                colUsed[y][num] = true;
                squareUsed[square][num] = true;

                backtrack(depth + 1);

                map[x][y] = 0;
                rowUsed[x][num] = false;
                colUsed[y][num] = false;
                squareUsed[square][num] = false;
            }
        }
    }

    static int getSquareIndex(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }

    static void printMap() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
