
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, max;
    static int[][] map;

    static Position[][] wormHoles;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] changeDirections = {
            {0, 1, 2, 3},
            {2, 3, 1, 0},
            {1, 3, 0, 2},
            {3, 2, 0, 1},
            {2, 0, 3, 1},
            {2, 3, 0, 1}
    };

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N + 2][N + 2];
            wormHoles = new Position[11][2];
            max = 0;

            for(int[] m : map){
                Arrays.fill(m, 5);
            }

            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
                for(int j = 1; j <= N; j++){
                    int no = Integer.parseInt(st.nextToken());

                    map[i][j] = no;

                    if( 6 <= no && no <= 10){
                        if( Objects.isNull(wormHoles[no][0])){
                            wormHoles[no][0] = new Position(i, j);
                        }else{ // wormHoles not null
                            wormHoles[no][1] = new Position(i, j);
                        }
                    }

                }
            }

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(map[i][j] != 0){
                        continue;
                    }

                    for(int d = 0; d < 4; d++){
                        solve(i, j, d);
                    }
                }
            }


            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);

    }

    static void solve(int x, int y, int d){
        int cnt = 0;
        Position position = new Position(x, y);


        position.x = x + dx[d];
        position.y = y + dy[d];

        while(true){

            //  원래 위치 , 블랙홀
            if( (position.x == x && position.y == y) || map[position.x][position.y] == -1 ){
                max = Math.max(max, cnt);
                return;
            }

            // 블록 만나기
            int type = map[position.x][position.y];

            if( 1 <= type && type <= 5){
                d = changeDirections[type][d];
                cnt++;
            }

            // 포탈
            if( 6 <= type && type <= 10){
                Position portal = wormHoles[type][0];
                Position nextPortal = wormHoles[type][1];

                if(portal.x == position.x && portal.y == position.y){
                    position.x = nextPortal.x;
                    position.y = nextPortal.y;
                }else{
                    position.x = portal.x;
                    position.y = portal.y;
                }
            }


            position.x = position.x + dx[d];
            position.y = position.y + dy[d];

        }
    }

    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
//10
//0 1 0 3 0 0 0 0 7 0
//0 0 0 0 -1 0 5 0 0 0
//0 4 0 0 0 3 0 0 2 2
//1 0 0 0 1 0 0 3 0 0
//0 0 3 0 0 0 0 0 6 0
//3 0 0 0 2 0 0 1 0 0
//0 0 0 0 0 1 0 0 4 0
//0 5 0 4 1 0 7 0 0 5
//0 0 0 0 0 1 0 0 0 0
//2 0 6 0 0 4 0 0 0 4