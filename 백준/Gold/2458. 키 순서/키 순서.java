
import java.util.*;

//
public class Main {

    static int N, M, count, result;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            int before = sc.nextInt();
            int next = sc.nextInt();

            graph[before][next] = 1;
        }


        for(int i = 1; i <= N; i++){
            count = 1;
            visited = new boolean[N + 1];
            solve(i);
        }

        System.out.println(result);

    }

    static void solve(int x){

        Queue<Integer> queue = new ArrayDeque<>();
        visited[x] = true;

        // 위로 아는 애들
        queue.offer(x);

        while(!queue.isEmpty()){
            int before = queue.poll();

            for(int i = 1; i <= N; i++){

                if(!visited[i] && graph[i][before] == 1){
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }

            }
        }

        queue = new ArrayDeque<>();
        queue.offer(x);

        while(!queue.isEmpty()){
            int bofore = queue.poll();

            for(int i = 1; i <= N; i++){
                if(!visited[i] && graph[bofore][i] == 1){
                    queue.offer(i);
                    count++;
                    visited[i] = true;


                }
            }
        }

        if(count == N){
            result++;
        }

    }
}
//6 6
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2
