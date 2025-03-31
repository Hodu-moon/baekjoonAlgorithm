
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, coreCount, maxCoreCount, lineLength;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Core> cores = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreCount = 0;
            cores = new ArrayList<>();
            maxCoreCount = 0;
            lineLength = 0;

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(map[i][j] == 1){
                        cores.add(new Core(i, j));
                        coreCount++;
                    }

                }
            }

            back(0,0 ,0);

            sb.append("#").append(t).append(" ").append(lineLength).append("\n");
        }

        System.out.println(sb);
    }

    static void printMap(){
        for(int[] xx : map){
            System.out.println(Arrays.toString(xx));
        }
    }

    static void back(int depth, int currentCoreCount, int line){
        if(depth == coreCount){


            if(currentCoreCount > maxCoreCount){
//                System.out.println(" ====== 다를 때 =======");
//                System.out.println( " currentCoreCount : " + currentCoreCount + " line : " + line);
//                System.out.println("maxCoreCount : " + maxCoreCount + " lineLength : " + lineLength);
//                System.out.println();
//
//                printMap();

                maxCoreCount = currentCoreCount;
                lineLength = line;
            }else if(currentCoreCount == maxCoreCount && line > 0){
//                System.out.println("========= 같을 때  =========");
//                System.out.println(" currentCoreCount : " + currentCoreCount + " line : " + line);
//                System.out.println("maxCoreCount : " + maxCoreCount + " lineLength : " + lineLength);
//                System.out.println();
//
//                printMap();

                lineLength = Math.min(lineLength, line);
            }


            return;
        }
           Core core = cores.get(depth);

        // 방향에 따라
        for(int dir = 0; dir < 4; dir++){
            if(canConnect(core, dir)){
                int count = fillLine(core, dir);
                back(depth + 1, currentCoreCount + 1, line + count);
                fillZero(core, dir);
            }
        }

        back(depth + 1, currentCoreCount, line);

    }


    // 1. 전선을 채우는 함수, 롤백하는 함수
    static private int fill(Core core, int dir, int type ){
        int count = 0;

        int x = core.x;
        int y = core.y;
        for(int l = 1; ; l++){
            int nx = x + dx[dir] * l;
            int ny = y + dy[dir] * l;

            if(!isIn(nx, ny)){
                return count;
            }
            map[nx][ny] = type;

            count++;

        }



    }
    static int fillZero(Core core, int dir){
        return fill(core, dir, 0);
    }

    static int fillLine(Core core, int dir){
        return fill(core, dir, 2);
    }

    //2. 전선을 연결할 수 있는지 확인하는 함수
    static boolean canConnect(Core core, int dir){
        int x = core.x;
        int y = core.y;

        for(int i = 1; ; i++){
            x = x + dx[dir];
            y = y + dy[dir];

            if(!isIn(x, y)){
                return true;
            }

            if(map[x][y] == 1 || map[x][y] == 2){
                return false;
            }

        }
    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }



    static class Core{
        int x, y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Core{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

//7
//0 0 1 0 0 0 0
//0 0 1 0 0 0 0
//0 0 0 0 0 1 0
//0 0 0 0 0 0 0
//1 1 0 1 0 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 0 0