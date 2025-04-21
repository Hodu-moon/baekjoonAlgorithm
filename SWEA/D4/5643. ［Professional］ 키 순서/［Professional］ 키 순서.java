
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    static boolean[][] graph;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());
            result = 0;

            graph = new boolean[N+1][N+1];

            for(int i = 0; i < M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from][to] = true;
            }

            solve();




            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void solve(){
        for(int i = 1; i <= N; i++){
            int cnt = 0;

//            System.out.println(i);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);


            boolean[] visited = new boolean[N+1];
            visited[i]= true;

            while(!queue.isEmpty()){

                int from = queue.poll();

                for(int to = 1; to <= N; to++){
                    if(visited[to])
                        continue;

                    if(graph[from][to]) {
//                        System.out.println("from = " + from);
//                        System.out.println("to = " + to);
                        queue.offer(to);
                        visited[to] = true;
                        cnt++;
                    }
                }
            }

            visited = new boolean[N+1];
            queue = new ArrayDeque<>();
            queue.offer(i);
            visited[i]= true;

            while(!queue.isEmpty()){
                int to = queue.poll();

                for(int from = 1; from <= N; from ++){
                    if(visited[from])
                        continue;

                    if(graph[from][to]){
                        visited[from] = true;
                        queue.offer(from);
                        cnt++;
                    }
                }
            }

            if(cnt == N -1){
//                System.out.println(i + " count++");
                result++;
            }




        }
    }
}
//
//        1
//        6
//        6
//        1 5
//        3 4
//        5 4
//        4 2
//        4 6
//        5 2
