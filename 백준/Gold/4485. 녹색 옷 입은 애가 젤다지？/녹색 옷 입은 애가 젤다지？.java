
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] map;

    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;
        while(true){
            N = Integer.parseInt(br.readLine());

            if(N == 0){
                break;
            }

            map = new int[N][N];
            visited = new boolean[N][N];
            result = new int[N][N];




            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j= 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();

            sb.append("Problem ").append(cnt++).append(": ").append(result[N-1][N-1]).append("\n");

        }

        System.out.println(sb);

    }

    static void dijkstra(){

        for(int i = 0; i < N; i++){
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        result[0][0] = 0;
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(0, 0, map[0][0]));

        while(!pq.isEmpty()){
            // step 1 : 최적의 정점 찾기
            Position current = pq.poll();

            visited[current.x][current.y] = true;
            result[current.x][current.y] = current.weight;

            // step 2:

            for(int d = 0; d < 4; d++){
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if(!isIn(nx, ny))
                    continue;

                if(visited[nx][ny])
                    continue;

                if(result[nx][ny] > result[current.x][current.y] + map[nx][ny]){
                    result[nx][ny] = result[current.x][current.y] + map[nx][ny];
                    pq.offer(new Position(nx, ny, result[nx][ny]));
                }


            }

        }


    }


    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    static class Position implements Comparable<Position>{
        int x, y, weight;

        public Position(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Position o) {
            return Integer.compare(weight, o.weight);
        }
    }
}

//3
//5 5 4
//3 9 1
//3 2 7
//0