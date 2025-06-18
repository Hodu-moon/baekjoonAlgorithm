
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] map;
    static int[] temp;
    static List<Integer> virus;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        virus = new ArrayList<>();
        temp = new int[M];

        // 입력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();

                if(map[i][j] == 2){
                    virus.add( (i * N) + j);
                }
            }
        }

        result = 999999;

        back(0, 0);

        System.out.println(result == 999999 ? -1 : result);
    }

    static void back(int depth, int startWith){
        if(depth == M){
            BFS();
            return ;
        }

        for(int i = startWith; i < virus.size(); i++){
            temp[depth] = virus.get(i);
            back(depth + 1, i + 1);
        }
    }

    static void BFS(){

        int[][] copyMap = copyMap();
        Queue<Position> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        for(int activeVirusPosition : temp){
            int x = activeVirusPosition / N;
            int y = activeVirusPosition % N;

            visited[x][y] = true;
            queue.offer(new Position(x, y));
        }

        int time = 0;


        while(!queue.isEmpty()){

            if(checkMap(copyMap)){
                result = Math.min(result, time);
                return;
            }

            time++;
            int size = queue.size();
//            System.out.println(size);
            for(int i = 0; i < size; i++) {
                Position current = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];

                    if(!isIn(nx, ny) || visited[nx][ny])
                        continue;

                    if(copyMap[nx][ny] == 1){
                        continue;
                    }

                    // 벽 아님 , 비활성 바이러스 거나 빈곳
                    queue.offer(new Position(nx, ny));
                    visited[nx][ny] = true;
                    copyMap[nx][ny] = 2;
                }
            }

        }

    }

    static boolean checkMap(int[][] map){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }

        return  true;

    }

    static int[][] copyMap(){
        int[][] temp = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
//7 3
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 2 0 1 1
//0 1 0 0 0 0 0
//2 1 0 0 0 0 2
