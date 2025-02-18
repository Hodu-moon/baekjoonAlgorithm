
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int R, C, N;
    static boolean[][][] map;

    static StringBuilder sb =new StringBuilder();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        map = new boolean[4][R][C];
        sc.nextLine();
//.......
        for (int i = 0; i < R; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < C; j++) {
                char x = input.charAt(j);
                map[0][i][j] = (x == 'O');
            }
        }

        for(int i = 1; i < 4; i++){
            fillBomb(map[i]);
        }

        fillMap2(map[2]);
        fillMap3();


        if( N % 2 == 0){
            printMap(map[1]);
        }else{
            if (N == 1) {
                printMap(map[0]);
            }else if(N % 4 == 1 ){
                printMap(map[3]);
            }else if(N % 4 == 3){
                printMap(map[2]);
            }

        }

        System.out.println(sb.toString());
    }

    static void fillMap3(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[2][i][j]){
                    map[3][i][j] = false;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(isIn(nx, ny)){
                            map[3][nx][ny] = false;
                        }
                    }
                }
            }
        }
    }

    // map 0 에 있던 터트리고
    static void fillMap2(boolean[][] arr){

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[0][i][j]){
                    arr[i][j] = false;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(isIn(nx, ny)){
                            arr[nx][ny] = false;
                        }
                    }
                }
            }
        }
    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static void fillBomb(boolean[][] map){
        for(boolean[] x : map){
            Arrays.fill(x, true);
        }
    }

    static void printMap(boolean[][] arr) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j])
                    sb.append("O");
                else
                    sb.append(".");
            }

            sb.append("\n");
        }
    }
}
