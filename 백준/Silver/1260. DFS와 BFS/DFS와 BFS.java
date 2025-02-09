

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [][]graph1;
    static int [][]graph11;
    static boolean []visited1;
    static int [][]graph2;
    static boolean []visited2;

    static int V;
    static StringBuilder sb;
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph1 = new int[N+1][N+1];
        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];


        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph1[n][m] = graph1[m][n] = 1;
        }
        sb = new StringBuilder();
        DFS(V);
        sb.append("\n");
        BFS(V);
        System.out.println(sb);
    }

    static void DFS(int V) {
        visited1[V] = true;
        sb.append(V).append(" ");

        for (int i = 1; i < graph1.length; i++) {
            if (!visited1[i] && graph1[V][i] == 1) {
                DFS(i);
            }
        }
    }
    static void BFS(int V){
        visited2[V] = true;
        sb.append(V).append(" ");
        queue.offer(V);
        while(!queue.isEmpty()){
            int r = queue.poll();
            for(int i = 1; i < graph1.length; i++){
                if(!visited2[i] && graph1[r][i] == 1){
                    visited2[i] = true;
                    sb.append(i).append(" ");
                    queue.add(i);
                }
            }
        }
    }

}