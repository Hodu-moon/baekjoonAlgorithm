
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 99999999;
    static int N, M, F;
    static int[][] dist;
    static int[] friends;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j)
                    continue;

                dist[i][j] = INF;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            dist[start][end] = distance;
        }

        F = Integer.parseInt(br.readLine());
        friends = new int[F ];
        st = new StringTokenizer(br.readLine());
        for(int f = 0; f < F; f++){
            friends[f] = Integer.parseInt(st.nextToken());
        }

        // 경출도
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(i == k )
                    continue;
                for(int j = 1; j <= N; j++){
                    if(j == i || j == k)
                        continue;

                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // 1번을 선택했을 때
        // 친구들
        List<Integer> list = new ArrayList<>();

        long result = Long.MAX_VALUE;
        for(int cityIndex = 1; cityIndex <= N; cityIndex++ ){

            long maxTrip = 0;

            for(int friendsIndex = 0; friendsIndex < F; friendsIndex++){
                int friendCityIndex = friends[friendsIndex];

                int forward = dist[friendCityIndex][cityIndex];
                int back = dist[cityIndex][friendCityIndex];

                if(forward == INF || back == INF){
                    maxTrip = -1;
                    break;
                }

                maxTrip = Math.max(maxTrip, back + forward);


            }

//            System.out.println(sum);
            if(maxTrip == -1)
                continue;

            if(result > maxTrip ){
                result = maxTrip;
                list = new ArrayList<>();
                list.add(cityIndex);
            }else if(result == maxTrip){
                list.add(cityIndex);
            }

        }

        Collections.sort(list);

        for(int key : list){
            System.out.print(key + " ");
        }



    }
}
//4 9
//1 2 9
//2 3 9
//3 1 9
//1 4 1
//4 1 1
//2 4 1
//4 2 1
//3 4 1
//4 3 1
//3
//1 2 3
