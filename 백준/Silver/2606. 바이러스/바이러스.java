
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int graph[][];
    static int virus;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];



        while (M --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;

        }
        checkVirus(1);
        System.out.println(virus);

    }

    static void checkVirus(int V){
        visited[V] = true;
        for(int i = 1; i < graph.length; i++){
            if(graph[V][i] == 1 && !visited[i] ){
                    virus++;
                    checkVirus(i);
            }
        }

    }



}
