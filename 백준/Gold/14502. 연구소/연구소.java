
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// 아이디어
// 1. 벽 3개 세우기 -> 조합
// 2. 퍼지게 하기 
public class Main{
    static int N, M, result, wallCount;
    static int[][] originMap;
    static List<Position> virusList;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];
        visited = new boolean[N][M];
        virusList = new ArrayList<>();
        wallCount = 3;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j= 0 ; j < M; j++){
                originMap[i][j] = Integer.parseInt(st.nextToken());
                if(originMap[i][j] == 1){
                    visited[i][j] = true;
                    wallCount++;
                }

                if(originMap[i][j] == 2){
                    virusList.add(new Position(i, j));
                    visited[i][j] = true;
                }
            }
        }

        combination(0, 0);

        System.out.println(result);
    }

    static void combination(int depth, int startWith){
        // 기저
        if(depth == 3){

            // ArraysClone 해도 될가요 ??
            solve();

            return;
        }

        // 유도

        for(int i = startWith; i < N * M; i++){

            // 1. 추가
            int x = i / M;
            int y = i % M;

            if(visited[x][y])
                continue;

            visited[x][y] = true;
            originMap[x][y] = 1;
            combination(depth + 1, i + 1);


            visited[x][y] = false;
            originMap[x][y] = 0;

        }


    }

    static void solve(){
        // queue
        Queue<Position> queue = new ArrayDeque<>();
        // 원복
        List<Position> positionList = new ArrayList<>();

        for(Position position : virusList){
            queue.offer(position);
        }

        int cnt = 0;
        // 바이라스 뿌리기
        while (!queue.isEmpty()) {
            Position current = queue.poll();


            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(!isIn(nx, ny))
                    continue;

                if(visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                queue.offer(new Position(nx, ny));
                cnt++;
                positionList.add(new Position(nx, ny));
            }

        }

        result = Math.max(result,  N * M - (wallCount + cnt + virusList.size()));


        for(Position virus : positionList){
            visited[virus.x][virus.y] = false;
        }
    }

    static void printMap(){
        for(int[] xx : originMap){
            System.out.println(Arrays.toString(xx));
        }
    }

    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
//4 6
//0 0 0 0 0 0
//1 0 0 0 0 2
//1 1 1 0 0 2
//0 0 0 0 0 2
