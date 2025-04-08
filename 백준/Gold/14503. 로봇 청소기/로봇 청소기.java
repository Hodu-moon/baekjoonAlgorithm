import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, result;
    static Cleaner cleaner;

    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        cleaner = new Cleaner(x, y, dir);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        System.out.println(result);
    }

    static void solve(){
        boolean flag = false;

        while(true){


            // 1. 빈칸이 있다면 청소함
            if(map[cleaner.x][cleaner.y] == 0){
                result++;
                map[cleaner.x][cleaner.y] = 2;
            }

            if(!cleaner.find()){            // 2. 주변을 보고 청소할 곳이 없는경우


                // 1. 방향 유지 후 후진 1칸
                // 2. 후진하는 곳이 벽이면 작동을 멈춤

                if(!cleaner.moveBack()){
//                    System.out.println("here!");
                    flag = true;
                }

            }else{ // cleaner.find() 청소할 곳이 있는 경우

                for(int i = 0; i < 4; i++){
                    cleaner.turn90();
                    if(cleaner.findFront()){
                        cleaner.moveFront();
                        break;
                    }
                }

            }


//            System.out.println(cleaner);
//            printMap();

            if (flag)
                break;


        }

    }

    static class Cleaner{
        int x, y, dir;

        public Cleaner(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        void turn90(){
            dir = (dir + 4 - 1) % 4;
        }



        boolean findFront(){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!isIn(nx, ny))
                return false;

            if(map[nx][ny] == 0)
                return true;

            return false;
        }

        boolean find(){

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(!isIn(nx, ny))
                    continue;

                if(map[nx][ny] == 0)
                    return true;
            }

            return false;
        }



        boolean moveBack(){
            int d = (dir + 2) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!isIn(nx, ny)){
                System.out.println(nx + " " + ny);
                return false;
            }

            if(map[nx][ny] == 1){
                return false;
            }

            x = nx;
            y = ny;

            return true;
        }

        void moveFront(){
            x = x + dx[dir];
            y = y + dy[dir];

        }

        boolean isIn(int x, int y){
            return 0 <= x && x < N && 0 <= y && y < M;
        }


        @Override
        public String toString() {
            return "Cleaner{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    '}';
        }
    }

    static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M ; j++){
                if(cleaner.x == i && cleaner.y == j){
                    System.out.print("* " );
                }else{
                    System.out.print(map[i][j] + " ");

                }
            }
            System.out.println();

        }

        System.out.println();
    }
}
// 북 동 남 서
//3 3
//1 1 0
//1 1 1
//1 0 1
//1 1 1
