

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, K, W;
    static int[] originTimes,resultTimes, inDegree;
    static List<List<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            originTimes = new int[N + 1];
            resultTimes = new int[N + 1];
            inDegree = new int[N + 1];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 1; i <= N; i++){
                originTimes[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();
            for(int i = 0; i <= N; i++)
                graph.add(new ArrayList<>());


            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int before = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                graph.get(before).add(next);
                inDegree[next]++;
            }

            W = Integer.parseInt(br.readLine());

            topologySort();



            sb.append(resultTimes[W]).append("\n");
        }

        System.out.println(sb);

    }

    static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                resultTimes[i] = originTimes[i];
            }
        }

        while(!queue.isEmpty()){
            int before = queue.poll();

            for(int next : graph.get(before)){

                inDegree[next]--;
                resultTimes[next] = Math.max(resultTimes[next], resultTimes[before] + originTimes[next] );

                if(inDegree[next] == 0){
                    queue.offer(next);

                    if(next == W){
                        return;
                    }
                }
            }

        }


    }
}
//4 4
//10 1 100 10
//1 2
//1 3
//2 4
//3 4
//4
