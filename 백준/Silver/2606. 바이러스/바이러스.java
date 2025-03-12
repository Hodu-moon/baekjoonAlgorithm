
import java.util.*;

public class Main {
    static int N, result;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N + 1][N + 1];
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int before = sc.nextInt();
            int next = sc.nextInt();
            graph[before][next] = graph[next][before] = 1;
        }

        BFS(1);
        System.out.println(result);

    }
    static void BFS(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int before = queue.poll();

            for(int i = 1; i <= N; i++){

                if(!visited[i] && graph[before][i] == 1){
                    visited[i] = true;
                    queue.offer(i);
                    result++;
                }
            }

        }
    }

    // 7
    //6
    //1 2
    //2 3
    //1 5
    //5 2
    //5 6
    //4 7
}
