
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int X, Y, K;
    static int minInjectCount;
    static int[][] map ;

    static int[] injectedRows;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            minInjectCount = Integer.MAX_VALUE;
            map = new int[X][Y];
            for(int i = 0; i < X; i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j = 0; j < Y ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            injectedRows = new int[X];

            solve(0, 0);



            sb.append("#").append(t).append(" ").append(minInjectCount).append("\n");
        }

        System.out.println(sb);

    }



    static void solve(int depth, int injectCount){


        if(injectCount > minInjectCount){
            return;
        }

        if(depth == X){

            if(check()){

                minInjectCount = Math.min(minInjectCount, injectCount);
            }
            return;
        }




        for(int i = -1; i <= 1; i++){

            injectedRows[depth] = i;

            if(i == -1){
                solve(depth + 1, injectCount);
            }else{
                solve(depth + 1, injectCount + 1);
            }
        }


    }

    static boolean check(){



        for(int j = 0; j < Y; j++){
            int cnt = 1;
            for(int i = 0; i < X - 1; i++){
                int current = injectedRows[i] == -1 ? map[i][j]  : injectedRows[i];
                int next = injectedRows[i + 1] == -1 ? map[i + 1][j] :  injectedRows[i + 1] ;

                if(current == next){
                    cnt++;
                }else{
                    cnt = 1;
                }

                if(cnt >= K){
                    break;
                }
            }

            if(cnt < K){
                return false;
            }
        }

        return true;
    }
}
//6 8 3
//0 0 1 0 1 0 0 1
//0 1 0 0 0 1 1 1
//0 1 1 1 0 0 0 0
//1 1 1 1 0 0 0 1
//0 1 1 0 1 0 0 1
//1 0 1 0 1 1 0 1
