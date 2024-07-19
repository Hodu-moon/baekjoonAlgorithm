import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    // 자식과의 관계 수
    static int M;
    static int x;
    static int y;
    static boolean[][] relation;

    static int xp;
    static int yp;
    static int count;

    static boolean[][] visited;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        relation = new boolean[N + 1][N + 1];
        visited = new boolean[N+1][N+1];
        for(int i = 0 ; i < M; i++){
            s = br.readLine();
            st = new StringTokenizer(s);

            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            if(ry == x){
                xp = ry;
            }

            if(ry == y){
                yp = ry;
            }

            relation[rx][ry] = true;
        }


        // 둘다 부모가 없으면
        if(xp == 0 && yp == 0) {
            System.out.println(-1);
            return;
        }


        dfs(x, 0);

        if(!check){
            System.out.println(-1);
        }



    }

    static void dfs(int x, int c){

        if(x == y){
            count = c;
            check= true;
            System.out.println(count);
            return;
        }

        for(int i = 0; i < N + 1; i++){
            if( relation[x][i]  && !visited[x][i]){
                visited[x][i] = true;
                visited[i][x] = true;
                dfs(i, c + 1);
            }

            if(relation[i][x] && !visited[i][x]){
                visited[i][x] = true;
                visited[x][i] = true;
                dfs(i, c + 1);
            }
        }

    }
}
