
import java.util.*;

public class Main {
    static final int N = 9;

    static int[][] map;

    static boolean[][] rowUsed, colUsed, blockUsed;

    static List<Position> zeroList;

    static boolean flag;

    public static void main(String[] args) {
        map = new int[N][N];
        Scanner sc = new Scanner(System.in);

        rowUsed = new boolean[N + 1][N + 1];
        colUsed = new boolean[N + 1][N + 1];
        blockUsed = new boolean[N + 1][N + 1];
        zeroList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 0) {
                    zeroList.add(new Position(i, j));
                } else {
                    rowUsed[i][map[i][j]] = true;
                    colUsed[j][map[i][j]] = true;
                    blockUsed[getBlockIdx(i, j)][map[i][j]] = true;
                }
            }
        }

        back(0);


    }

    static void back(int depth) {
        if(flag)
            return;

        // 기저조건
        if (depth == zeroList.size()) {
            pirntMap();
            flag = true;

            return;
        }

//        pirntMap();

        // 유도조건
        Position position = zeroList.get(depth);

//        System.out.println(position);
//        System.out.println(getBlockIdx(position.x, position.y));

        for (int num = 1; num <= 9; num++) {

//            System.out.println("num : " + num);
            if (colUsed[position.y][num]) {
//                System.out.println("1");
                continue;
            }

            if (rowUsed[position.x][num]) {
//                System.out.println(2);
                continue;
            }

            if (blockUsed[getBlockIdx(position.x, position.y)][num]) {
//                System.out.println(3);
                continue;
            }


            colUsed[position.y][num] = true;
            rowUsed[position.x][num] = true;
            blockUsed[getBlockIdx(position.x, position.y)][num] = true;
            map[position.x][position.y] = num;

            back(depth + 1);


            colUsed[position.y][num] = false;
            rowUsed[position.x][num] = false;
            blockUsed[getBlockIdx(position.x, position.y)][num] = false;
            map[position.x][position.y] = 0;


        }

    }

    static int getBlockIdx(int x, int y) {

        return ((x / 3) * 3) + y / 3;
    }

    static void pirntMap() {
        for (int[] xx : map) {
            for (int x : xx) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

//0 3 5 4 6 9 2 7 8
//7 8 2 1 0 5 6 0 9
//0 6 0 2 7 8 1 3 5
//3 2 1 0 4 6 8 9 7
//8 0 4 9 1 3 5 0 6
//5 9 6 8 2 0 4 1 3
//9 1 7 6 5 2 0 8 0
//6 0 3 7 0 1 9 5 2
//2 5 8 3 9 4 7 6 0