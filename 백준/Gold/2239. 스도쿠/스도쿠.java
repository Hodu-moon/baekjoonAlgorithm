
import java.util.*;

public class Main{

    static int[][] map;
    static boolean finish;
    static final int N = 9;

    static List<Position> positionList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        positionList = new ArrayList<>();

        map = new int[N][N];
        for(int i = 0; i < N ; i++){
            String input = sc.nextLine();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j) - '0';
                if(map[i][j] == 0){
                    positionList.add(new Position(i, j));
                }
            }
        }

        back(0);


    }

    static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void back(int depth){
//        System.out.println(depth);
//        System.out.println("print map");
//        printMap();
//        System.out.println();

        if(depth == positionList.size()){



            Position position = positionList.get(depth - 1);

            int[] temp = new int[N + 1];
            // row
            for(int i = 0; i < N; i++){
                int f = map[position.x][i];

                if(f > 0){
                    if(++temp[f] > 1 ) {
//                        System.out.println(" row !!");
                        return;
                    }
                }
            }

            temp = new int[N + 1];
            // column
            for(int i = 0; i < N; i++){
                int f = map[i][position.y];

                if(f > 0){
                    if(++temp[f] > 1 ) {
//                        System.out.println(" col !!");

                        return;
                    }
                }
            }


            int x = position.x / 3;
            int y = position.y / 3;

            temp = new int[N+1];
            for(int i = x * 3; i < (x *3) + 3; i++){
                for(int j = y * 3 ; j < (y* 3 )+ 3; j++){
                    int f = map[i][j];

                    if(f > 0){

                        if(++temp[f] > 1){
//                            System.out.println(" block !!");
                            return;
                        }
                    }
                }
            }


//            System.out.println("print map");
            printMap();
//            System.out.println();

            finish = true;
            return;
        }

        if(finish)
            return;


        // 개수로 가자이
        if(depth > 0){

            Position position = positionList.get(depth - 1);

            int[] temp = new int[N + 1];
            // row
            for(int i = 0; i < N; i++){
                int f = map[position.x][i];

                if(f > 0){
                    if(++temp[f] > 1 ) {
//                        System.out.println(" row !!");
                        return;
                    }
                }
            }

            temp = new int[N + 1];
            // column
            for(int i = 0; i < N; i++){
                int f = map[i][position.y];

                if(f > 0){
                    if(++temp[f] > 1 ) {
//                        System.out.println(" col !!");

                        return;
                    }
                }
            }


            int x = position.x / 3;
            int y = position.y / 3;

            temp = new int[N+1];
            for(int i = x * 3; i < (x *3) + 3; i++){
                for(int j = y * 3 ; j < (y* 3 )+ 3; j++){
                    int f = map[i][j];

                    if(f > 0){

                        if(++temp[f] > 1){
//                            System.out.println(" block !!");
                            return;
                        }
                    }
                }
            }
        }

        Position current = positionList.get(depth);

        for(int i = 1; i <= 9; i++){
            map[current.x][current.y] = i;
            back(depth + 1);
            map[current.x][current.y] = 0;
        }
    }

    static boolean blockCheck(int x, int y){
        boolean[] checked = new boolean[N + 1];

        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++ ){
                if(checked[map[i][j]]){
                    return false;
                }

                checked[map[i][j]] = true;
            }
        }

        return true;

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

//143628579
//572139468
//986754231
//391542786
//468917352
//725863914
//237481695
//619275843
//854396127