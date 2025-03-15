
//활주로 건설

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution  {
    static int N, K,result;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(),  " ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

            }

            solve();


            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    static void solve(){
        for(int i = 0; i < N; i++){
//            System.out.println("=============" + i + " ============");
            visited = new boolean[N];
            solveCol(i);
            visited = new boolean[N];
            solveRow(i);
        }
    }

    static void solveRow(int row){
        for(int col = 0; col < N - 1; col++){
            int start = map[row][col];
            int next = map[row][col + 1];

            if(start == next){
                continue;
            }

            if(Math.abs(start - next) > 1){
                return;
            }

            if(start - next == -1){
                for(int k = 0; k < K; k++){

                    if(!isIn(row, col - k)){
                        return;
                    }

                    if(visited[col - k]){
                        return;
                    }

                    if(start != map[row][col - k]){
                        return;
                    }


                }

            }else if(start - next == 1){

                for(int k = K; k > 0; k--){

                    if(!isIn(row, col + k)){
                        return;
                    }

                    if(start - 1 != map[row][col + k]){
                        return;
                    }else {
                        visited[col + k] = true;

                    }
                }
                col = col + K  -1;

            }


        }

//        System.out.println("row : " + row);
        result++;
    }

    static void solveCol(int col){
        for(int row = 0; row < N - 1; row++){
            int start = map[row][col];
            int next = map[row + 1][col];

            if(start == next )
                continue;

            if(Math.abs(start - next) > 1) // 높이가 1 초과일 수 없음
                return;

            if(start - next == -1){
                for(int k = 0; k < K; k++){

                    if(!isIn(row - k , col)){
                        return;
                    }
                    // 이미 공사 했다면
                    if(visited[row - k])
                        return;

                    if(start != map[row - k][col])
                        return;
                }
            }else if( start - next == 1){
                for(int k = K ; k > 0 ; k--){

                    if(!isIn(row + k, col)){
                        return;
                    }

                    if(start - 1 != map[row + k][col]){
                        return;
                    }else{
                        visited[row + k] = true;
                    }
                }

                row = row + K -1;

            }

        }
//        System.out.println("col : " + col);
        result++;

    }



    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }



}

//10
//
//6 2
//
//3 3 3 2 1 1
//
//3 3 3 2 2 1
//
//3 3 3 3 3 2
//
//2 2 3 2 2 2
//
//2 2 3 2 2 2
//
//2 2 2 2 2 2