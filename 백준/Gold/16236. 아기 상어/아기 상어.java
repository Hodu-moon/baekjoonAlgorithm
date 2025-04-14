
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// 1. 아기상어 level 관리하나
// 2. BFS돌리면서 초 세기 한개
public class Main{

    static int N, result;
    static int[][] map;

    static int[] total;
    static Shark shark;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9){
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }


            }
        }



        // 2. simulation

        bfs();
        System.out.println(result);

    }

    static void bfs() {
        while (true) {
            boolean[][] visited = new boolean[N][N];
            Queue<Position> queue = new ArrayDeque<>();
            List<Position> candidates = new ArrayList<>();

            queue.offer(new Position(shark.x, shark.y, 0));
            visited[shark.x][shark.y] = true;

            int minDist = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                Position cur = queue.poll();

                // 거리가 최소 거리보다 길면 탐색 종료
                if (cur.t > minDist) break;

                if (0 < map[cur.x][cur.y] && map[cur.x][cur.y] < shark.level) {
                    candidates.add(cur);
                    minDist = cur.t; // 현재 거리 기준 최소 거리 설정
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (!isIn(nx, ny) || visited[nx][ny]) continue;
                    if (map[nx][ny] > shark.level) continue;

                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, cur.t + 1));
                }
            }

            if (candidates.isEmpty()) return; // 더 이상 먹을 수 있는 물고기 없음

            // 우선순위 정렬
            candidates.sort((a, b) -> {
                if (a.t != b.t) return a.t - b.t;
                if (a.x != b.x) return a.x - b.x;
                return a.y - b.y;
            });

            Position target = candidates.get(0);

            // 물고기 먹기
            map[target.x][target.y] = 0;
            result += target.t;
            shark.x = target.x;
            shark.y = target.y;
            shark.totalEat++;

            if (shark.totalEat == shark.level) {
                shark.level++;
                shark.totalEat = 0;
            }

            // 디버깅용 출력
//            System.out.println(shark + " " + result);
//            System.out.println(target);
//            printMap();
//            System.out.println();
        }
    }

    static void bfs1(){
        boolean[][] visited = new boolean[N][N];
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(shark.x, shark.y, 0 ));
        visited[shark.x][shark.y] = true;

        // 1번 찾는거 해볼게요
        while(!queue.isEmpty()){
            Position current = queue.poll();


            if(0 < map[current.x][current.y] && map[current.x][current.y] < shark.level){
                shark.totalEat++;
                result += current.t;
                map[current.x][current.y] = 0;
                if(shark.totalEat == shark.level){
                    shark.level++;
                    shark.totalEat = 0;
                }
                shark.x = current.x;
                shark.y = current.y;

                System.out.println(shark + " " + result);
                System.out.println(current);
                printMap();
                System.out.println();


                queue.clear();



                visited = new boolean[N][N];
                visited[current.x][current.y] = true;

                queue.offer(new Position(current.x, current.y, 0));
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(!isIn(nx, ny))
                    continue;

                if(visited[nx][ny])
                    continue;

                if(map[nx][ny] > shark.level){
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new Position(nx, ny , current.t + 1) );

            }

        }

    }

    static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                if(shark.x == i && shark.y == j){
                    System.out.print("* ");
                }else{
                    System.out.print(map[i][j] + " ");

                }
            }
            System.out.println();
        }
    }


    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }


    static class Position{
        int x, y, t;

        public Position(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", t=" + t +
                    '}';
        }
    }

    static class Shark{
        int x, y, level, totalEat;
        int[] eats;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            totalEat = 0;
            level = 2;
            eats = new int[7]; // 1 ~ 6레벨 까지 있음
        }


        @Override
        public String toString() {
            return "Shark{" +
                    "level=" + level +
                    ", totalEat=" + totalEat +
                    '}';
        }
    }
}

//3
//0 0 0
//0 0 0
//0 9 0
