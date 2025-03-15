
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result, islandIdx;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        islandIdx = 2;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        printMap();

        //1. 섬찾기 islandIdx = 2 부터 시작


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if( map[i][j] == 1){
                    makeIsland(i, j);
                    islandIdx++;
                }
            }
        }

//        printMap();


        //2. 섬 간의 거리 찾기
        result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if( map[i][j] > 1){
                    visited = new boolean[N][N];
                    connectIsland(i, j);
                }
            }
        }

        System.out.println(result);

    }

    static void connectIsland(int x, int y){
        int beforeIslandIdx = map[x][y];
        visited[x][y] = true;
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(x, y, 0));

        // 4방 탐색으로 가야함
        while(!queue.isEmpty()){
            Position cur = queue.poll();
            // 여기에 꺼냈을 때 하는거

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                //result > 크면 가지치기
                if(result <= cur.count){
                    return;
                }


                if(!isIn(nx, ny))
                    continue;

                if(visited[nx][ny])
                    continue;
                // 탐색하려는 섬과 같으면
                if(beforeIslandIdx == map[nx][ny])
                    continue;



                if(map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx,ny, cur.count + 1));
                    continue;
                }

                if(beforeIslandIdx != map[nx][ny]){
                    result = Math.min(result, cur.count);
                    return;
                }


            }

        }

    }

    static void makeIsland(int x, int y){
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(x, y));
        map[x][y] = islandIdx;

        while(!queue.isEmpty()){
            Position cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isIn(nx, ny))
                    continue;

                if(map[nx][ny] == 1){
                    map[nx][ny] = islandIdx;
                    queue.offer(new Position(nx, ny));
                }

            }

        }

    }

    static class Position{
        int x, y, count;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static void printMap(){
        for(int [] xx : map){
            System.out.println(Arrays.toString(xx));
        }
    }
}
//10
//1 1 1 0 0 0 0 1 1 1
//1 1 1 1 0 0 0 0 1 1
//1 0 1 1 0 0 0 0 1 1
//0 0 1 1 1 0 0 0 0 1
//0 0 0 1 0 0 0 0 0 1
//0 0 0 0 0 0 0 0 0 1
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 1 1 0 0 0 0
//0 0 0 0 1 1 1 0 0 0
//0 0 0 0 0 0 0 0 0 0
