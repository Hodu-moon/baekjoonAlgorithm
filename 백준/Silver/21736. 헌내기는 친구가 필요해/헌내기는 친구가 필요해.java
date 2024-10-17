

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int count = 0;

    static int N;
    static int M;

    static char[][] array;
    static boolean[][] visited;

    static int[] I;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NMM = br.readLine();

        String[] split = NMM.split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        array = new char[N][M];
        visited = new boolean[N][M];


        for(int i = 0 ; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                array[i][j] = line.charAt(j);

                if(array[i][j] == 'I'){
                   I = new int[]{i, j};
                }

            }
        }

        dfs(I[0], I[1]);

        System.out.println(count == 0 ? "TT" : count);

    }

    public static void dfs(int i, int j){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        visited[i][j] = true;

        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            visited[pop[0]][pop[1]] = true;

            for(int ii = 0; ii < 4; ii++){
                int nx = pop[0] + dx[ii];
                int ny = pop[1] + dy[ii];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] &&
                    array[nx][ny] != 'X'
                ){

                    if(array[nx][ny] == 'P'){
                        count++;
                    }

                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }

        }




    }


}
