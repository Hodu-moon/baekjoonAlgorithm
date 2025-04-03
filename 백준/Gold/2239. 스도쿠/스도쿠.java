
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] rowUsed;
    static boolean[][] colUsed;
    static boolean[][] blockUsed;
    static List<Position> positionList = new ArrayList<>();

    static boolean finish;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[9][9];
        rowUsed = new boolean[9][10];
        colUsed = new boolean[9][10];
        blockUsed = new boolean[9][10];

        for(int i = 0; i < 9; i++){
            String input = sc.nextLine();
            for(int j = 0; j < 9; j++){
                int num = input.charAt(j) - '0';
                map[i][j] = num;

                if(num > 0){
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    blockUsed[getBlockIndex(i, j)][num] = true;
                }

                if(num == 0){
                    positionList.add(new Position(i, j));
                }
            }
        }
        back(0);
    }


    static void back(int depth){

        if(finish)
            return;

        if(depth == positionList.size()){

            for(int[] xx : map){
                for(int x : xx){
                    System.out.print(x);
                }
                System.out.println();
            }

            finish = true;
            return;
        }

        Position position = positionList.get(depth);

        for(int num = 1; num <= 9; num++){

            if(!rowUsed[position.x][num] && !colUsed[position.y][num]
                    && !blockUsed[getBlockIndex(position.x, position.y)][num]){


                rowUsed[position.x][num] =true;
                colUsed[position.y][num] = true;
                blockUsed[getBlockIndex(position.x,  position.y)][num] = true;

                map[position.x][position.y] = num;
                back(depth + 1);

                map[position.x][position.y] = 0;
                rowUsed[position.x][num] =false;
                colUsed[position.y][num] = false;
                blockUsed[getBlockIndex(position.x,  position.y)][num] = false;


            }
        }

    }
    static int  getBlockIndex(int x, int y){
        return ( x / 3 ) * 3 + y / 3;
    }

    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//103000509
//002109400
//000704000
//300502006
//060000050
//700803004
//000401000
//009205800
//804000107
