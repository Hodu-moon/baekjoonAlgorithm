
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, M, R;
    static final int INF = 99999999;
    static int[] items;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        items = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dist = new int[N + 1][ N + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j)
                    continue;
                dist[i][j] = INF;
            }
        }

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = distance;
        }


        // 경출도

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(k == i)
                    continue;

                for(int j = 1; j <= N; j++){
                    if(i == j || k == j)
                        continue;

                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

                }
            }
        }

//        for(int i = 1; i <= N; i++){
//            for(int j = 1; j <= N; j++){
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
        long result = 0;
        for(int i = 1; i <= N; i++){

            long sum = items[i];
            for(int j = 1; j <= N; j++){
                if(i != j && dist[i][j] <= M){
                    sum += items[j];
                }
            }
            result = Math.max(result, sum);

        }


        System.out.println(result);






    }
}
//5 5 4
//5 7 8 2 3
//1 4 5
//5 2 4
//3 2 3
//1 2 3
