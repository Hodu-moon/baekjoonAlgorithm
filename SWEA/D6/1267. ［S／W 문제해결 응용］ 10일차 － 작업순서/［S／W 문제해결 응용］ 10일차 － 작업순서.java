
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int V, E;
    static int[] inDegree;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph;
    public static void main(String[] args) throws Exception {
        // V 1000, E 3000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            graph = new ArrayList<>();
            inDegree = new int[V + 1];

            for(int i = 0; i <= V; i++)
                graph.add(new ArrayList<>());

            for(int i = 0; i < E; i++){
                int before = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                inDegree[next]++;

                graph.get(before).add(next);
            }

            sb.append("#").append(t).append(" ");

            topologySort();

            sb.append("\n");
        }


        System.out.println(sb);
    }

    static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= V; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                sb.append(i).append(" ");
            }
        }


        while(!queue.isEmpty()){
            int before = queue.poll();

            for(int next : graph.get(before)){

                inDegree[next]--;

                if(inDegree[next] == 0){
                    sb.append(next).append(" ");
                    queue.offer(next);
                }
            }


        }
    }

}

//9 9
//4 1 1 2 2 3 2 7 5 6 7 6 1 5 8 5 8 9
//5 4
//1 2 2 3 4 1 1 5