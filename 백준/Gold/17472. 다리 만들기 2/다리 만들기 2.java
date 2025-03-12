
import java.util.*;
import java.util.Scanner;

// 1. 섬 파악
// 2. 섬간의 거리 파악
// 3. MST prim
public class Main {
    static int islandIdx = 2;
    static int N, M, result;
    static int[][] map, graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int INF = 100000000;
    static List<Vertex> nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = -1;
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            for ( int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }
//        printMap();

        // 1. 섬 파악 - BFS
        islandIdx = 2;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    BFS(i, j);
                    islandIdx++;
                }
            }
        }
//        printMap();

        graph = new int[islandIdx][islandIdx];

        for(int[] xx : graph){
            Arrays.fill(xx, INF);
        }

        // 2. 섬 간의 거리 파악
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){

                    makeGraph(i, j);

            }
        }

//        printGraph();

        //3. mst - prim
        result = prim();


        System.out.println(result);


    }

    static int prim(){

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        Vertex[] vertexes = new Vertex[islandIdx];
        for(int i = 2; i < islandIdx; i++){
            if(i == 2){
                vertexes[i] = new Vertex(i, 0);
            }else{
                vertexes[i] = new Vertex(i, INF);
            }
            pq.offer(vertexes[i]);
        }
        int sumCosts = 0;

        while(!pq.isEmpty()){
            Vertex before = pq.poll();

            if(before.weight == INF){
                return -1;
            }
            sumCosts += before.weight;

            for(int i = 2; i < islandIdx; i++){
                Vertex next = vertexes[i];

                if(pq.contains(next)){

                    if(next.weight > graph[before.idx][next.idx]){
                        next.weight = Math.min(next.weight, graph[before.idx][next.idx]);

                        pq.remove(next);
                        pq.offer(next);
                    }

                }
            }


        }

        return sumCosts;
    }

    static class Vertex implements Comparable<Vertex>{
        int idx, weight;

        public Vertex(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }
    static void makeGraph(int x, int y){
        int before = map[x][y];

        // 1. 밖으로 나갔을 때
        // 2. 같은 거 만났을 때
        // 3. 0 만나면 바다 건너는중임
        // 4. 다른거 만났을 때
        for(int i = 0; i < 4; i++){
            for(int l = 1;; l++){
                int nx = x + dx[i] * l;
                int ny = y + dy[i] * l;

                if(!isIn(nx, ny)){ // 1
                    break;
                }

                if(before == map[nx][ny]){ // 2
                    break;
                }

                if(map[nx][ny] == 0){ // 0
                    continue;
                }

                int next = map[nx][ny];
                if(l - 1 >= 2)
                    graph[before][next] = graph[next][before] = Math.min(graph[next][before], l - 1);

                break;
            }
        }
    }

    static void printGraph(){
        System.out.println("======= graph =========");
        for(int[] xx : graph){
            System.out.println(Arrays.toString(xx));
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        map[x][y] = islandIdx;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!isIn(nx, ny))
                    continue;

                if(map[nx][ny] == 1 ){
                    map[nx][ny] = islandIdx;
                    queue.offer(new int[]{nx, ny});
                }

            }
        }

    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static void printMap(){
        for(int[] xx : map){
            System.out.println(Arrays.toString(xx));
        }
    }
}
//7 8
//0 0 0 0 0 0 1 1
//1 1 0 0 0 0 1 1
//1 1 0 0 0 0 0 0
//1 1 0 0 0 1 1 0
//0 0 0 0 0 1 1 0
//0 0 0 0 0 0 0 0
//1 1 1 1 1 1 1 1
