
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D, result;
    static int[][] map;
    static int[] temp;

    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        temp = new int[3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(result);
    }

    //1. 궁수 위치 지정
    static void combination(int depth, int startWith){
        if(depth == 3){
//            for(int i = 0; i < 3; i++){
//                System.out.print(temp[i] + " ");
//            }
//            System.out.println();
            solve();
            return;
        }

        for(int i = startWith; i < M; i++){
            temp[depth] = i;
            combination(depth + 1, i + 1);
            temp[depth] = 0;
        }

    }

    // 2. 게임 진행
    static void solve(){
        int[][] tempMap = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j= 0; j < M; j++){
                tempMap[i][j] = map[i][j];
            }
        }

        int cnt = 0;
        List<Queue<Position>> queueList = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            queueList.add(new ArrayDeque<>());
        }

        for(int i = N-1; i  >= 0; i--){ // N -> 0 줄
            Set<Position> set = new HashSet<>();

            for(int j = 0; j < 3; j++){
                Queue<Position> queue = queueList.get(j);
                queue.add(new Position(i, temp[j]));
                for(int d = 0; d < D; d++){
                    boolean flag = false;

                    int size = queue.size();

                    for(int s = 0; s < size; s++){
                        Position current = queue.poll();

                        if(tempMap[current.x][current.y] == 1){

                            //                            System.out.println(current);
                            set.add(current);
                            flag = true;
                            break;
                        }

                        for(int k = 0; k < 3; k++){
                            int nx = current.x + dx[k];
                            int ny = current.y + dy[k];

                            if(!isIn(nx, ny))
                                continue;

                            queue.offer(new Position(nx, ny));

                        }


                    }
                    if(flag )
                        break;


                }


                queueList.get(j).clear();
            }

            for(Position position : set){
                if(tempMap[position.x][position.y] == 1){
                    tempMap[position.x][position.y] = 0;

                    cnt++;
                }
            }

        }

        result = Math.max(result, cnt);
//        System.out.println(result);
    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static class Position{
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
// 1. 궁수 위치 지정
// 2. 게임 진행
